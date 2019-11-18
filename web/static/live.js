function send(message) {
    if (!window.WebSocket) { return; }
    if (socket.readyState == 1) {
        console.log("send: " + message);
        socket.send(message);
    } else {
        alertify.error("Failed to send action (Closed)");
        console.log("State " + socket.readyState)
    }
}

// SORT
devices = $(".devices");
devices.sort(function (a, b) {
      var contentA =parseInt( $(a).attr('data-prio'));
      var contentB =parseInt( $(b).attr('data-prio'));
    return contentA - contentB;
});
$("#live-devices").html(devices);

// MASTER
$("#master").on('input', function() {
    $.ajax({
        url : this.form.action,
        type: this.form.method,
        data: $(this.form).serialize()
    }).fail(function() {
        alertify.error("Failed to set master");
    });;
});
$(".scene-form").each(function(){
    $(this).on('submit', function(e) {
        e.preventDefault();
        $.ajax({
            url : this.action,
            type: this.method,
            data: $(this).serialize(),
            error: function (request, textStatus, errorThrown) {
                alertify.error("Scene load Failed! " + (request.getResponseHeader('message')));
            }
        });
    });
});
var timeout = false;
$('.valuerange').each(function(){
    $(this).on('input', function() {
        if ($("#master").val() < 3) {
            if (!timeout) {
                alertify.warning("Master is off");
                timeout = true;
                setTimeout(function() {
                    timeout = false;
                }, 1500);
            }
        }
        send("?" + $(this.form).serialize());
    });
});
$('.color-select').each(function(){
    var device = $(this).attr("data-device");
    $(this).spectrum({
        preferredFormat: "name",
        flat: true,
        showInput: true,
        cancelText: "",
        chooseText: "",
        move: function(color) {
            //console.log(color.toRgb());
            send(device + ":" + color.toRgb().r + ":" + color.toRgb().g + ":" + color.toRgb().b);
        }
    });
});
var sortable = new Sortable(document.getElementById('live-devices'), {
	animation: 150,
	ghostClass: 'blue-background-class',
	onUpdate: function (/**Event*/evt, /**Event*/originalEvent) {
	    var devices = new Map();
	    var i = 0;
	    $('.devices').each(function(){
	        devices.set($(this).find("h3").text(), i);
	        i = i + 1;
        });
        console.log(devices);
        var first = 1;
        var request = "";
        devices.forEach(function(value, key, map){
            if (first == 0) {
                request += "&";
            }
            request += key + "=" + value;
            first = 0;
        });
        console.log(request);
        $.ajax({
            url : "/liveaction/updatePrio",
            type: "get",
            data: request
        }).fail(function() {
            alertify.error("Failed to update prio");
        });;
	}
});

$('.scene-play').each(function(){
    if (is_touch_device()) {
        $(this).on('dblclick', function() {
            $(this.form).submit();
        });
    } else {
        $(this).prop("type", "submit");
    }
});

if ($.cookie("disable_drag_and_drop") != null) {
    $("#toggle-drag-and-drop").removeClass("btn-secondary");
    $("#toggle-drag-and-drop").addClass("btn-danger");
    sortable.option("disabled", true);
}
$("#toggle-drag-and-drop").on("click", function() {
    if ($.cookie("disable_drag_and_drop") == null) {
        $.cookie("disable_drag_and_drop", "1");
    } else {
        $.removeCookie("disable_drag_and_drop");
    }
    $("#toggle-drag-and-drop").toggleClass("btn-secondary");
    $("#toggle-drag-and-drop").toggleClass("btn-danger");
    sortable.option("disabled", !sortable.option("disabled"));
});

var socket;
if (!window.WebSocket) {
  window.WebSocket = window.MozWebSocket;
}
if (window.WebSocket) {
    socket = new WebSocket("ws://" + host + "/websocket");
    socket.onmessage = function(event) {
        console.log("rec: " + event.data);
        var split = event.data.split(":");

        if (split.length == 5) {
            $(".rgb-" + split[1]).spectrum("set", "rgb " + split[2] + " " + split[3] + " " + split[4]);
        } else {
            var element = $("." + split[0] + "-" + split[1]).parent().find("span");
            if (split[2] == "true") {
                element.addClass("text-info");
                element.removeClass("text-warning");
            } else {
                element.removeClass("text-info");
                element.addClass("text-warning");
            }
            if (split.length == 4) {
                document.getElementsByClassName(split[0] + "-" + split[1])[0].value = parseInt(split[3]);
            }
        }
    }
    socket.onclose = function(event) {
         alertify.error("Connection closed");
         console.log("CLOSE: " + socket.readyState)
    }
    socket.onopen = function(event) {
        alertify.success("Connected");
        send("register");
        console.log("OPEN: " + socket.readyState)
    }
} else {
    alert("Your browser does not support web sockets: Live update will be disabled");
}