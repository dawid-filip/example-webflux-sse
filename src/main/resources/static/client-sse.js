function fetchMessages() {
    clearMessages();

    var length = document.getElementById("elementInput").value;

    log("Opening EventSource and fetching " + length + " messages...");
	var eventSource = new EventSource('http://localhost:8080/api/sse/length/' + length);

	eventSource.addEventListener('message', function (e) {
	    // e.preventDefault(); // enable when using with window event
	    log(e.data);
	});

	eventSource.addEventListener('error', function (e) {
	    // se.preventDefault(); // enable when using with window event
	    log("Closing the EventSource")
	    eventSource.close();
	    log("Fetched " + length + " sse messages.")
    });


}

function clearMessages() {
    document.getElementById('elementMessages').innerHTML = "";
}

function log(msg) {
    var elementMessagesDiv = document.getElementById('elementMessages');
    var element = document.createElement('div');
    var text = document.createTextNode(msg);
    element.appendChild(text);
    elementMessagesDiv.append(element);
}