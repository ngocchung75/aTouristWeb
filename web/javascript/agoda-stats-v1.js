// The Agoda global namespace object. 
// If Agoda is already defined, the existing Agoda object will not be overwritten so that defined namespaces are preserved.
var Agoda = Agoda || {};

// extend Agoda with a new namespace: Stats
Agoda.Stats = Agoda.Stats || {};

// extend the namespace: Agoda.Stats with new functionality 
Agoda.Stats.send = function (type, id, p, async, elapsedTime) {
    var xmlhttp;
    var url = "/MessagingHandler.ashx";
    var params = "type=" + type + "&id=" + id + "&p=" + p + "&elapsedTime=" + elapsedTime;

    if (async == true) {
        window.setTimeout("Agoda.Http.post('" + url + "', '" + params + "');", 100);
    } else {
        Agoda.Http.post(url, params);
    }
};

