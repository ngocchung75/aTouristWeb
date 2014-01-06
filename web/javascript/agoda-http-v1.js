// The Agoda global namespace object. 
// If Agoda is already defined, the existing Agoda object will not be overwritten so that defined namespaces are preserved.
var Agoda = Agoda || {};

// extend Agoda with a new namespace: Http
Agoda.Http = Agoda.Http || {};

// extend the namespace: Agoda.Http with new functionality 
Agoda.Http.post = function (url, params) {
    if (window.XMLHttpRequest) { // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else { // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("http://www.agoda.com/pages/FileNotFound.aspx", url, true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send(params);
};
