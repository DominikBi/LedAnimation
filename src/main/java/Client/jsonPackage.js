var obj = {a: "name", b: 120}
var data = "text/json;charset=utf-8" + encodeURIComponent(JSON.stringify(obj));
var doc = document.createElement('doc');
doc.href = "data:" + data;
doc.download = 'data.json'
doc.innerHTML = 'download JSON';

var cont = document.getElementById('container')
container.appendChild(doc);

