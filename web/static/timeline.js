(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
function Do(parent) {
	var listeners = [];
	this.do = function(callback) {
		listeners.push(callback);
	};
	this.fire = function() {
		for (var v = 0; v < listeners.length; v++) {
			listeners[v].apply(parent, arguments);
		}
	};
}

if (typeof(module) === 'object') module.exports = Do;

},{}],2:[function(require,module,exports){
module.exports={"version":"1.5.0"}
},{}],3:[function(require,module,exports){
module.exports={
	"unitsPerEm": 1792,
	"ascender": 1536,
	"descender": -256,
	"fonts": {
		"plus": {
			"advanceWidth": 1408,
			"commands": "M,1408,800 C,1408,853,1365,896,1312,896 L,896,896 L,896,1312 C,896,1365,853,1408,800,1408 L,608,1408 C,555,1408,512,1365,512,1312 L,512,896 L,96,896 C,43,896,0,853,0,800 L,0,608 C,0,555,43,512,96,512 L,512,512 L,512,96 C,512,43,555,0,608,0 L,800,0 C,853,0,896,43,896,96 L,896,512 L,1312,512 C,1365,512,1408,555,1408,608 Z"
		},
		"zoom_in": {
			"advanceWidth": 1664,
			"commands": "M,1024,736 C,1024,753,1009,768,992,768 L,768,768 L,768,992 C,768,1009,753,1024,736,1024 L,672,1024 C,655,1024,640,1009,640,992 L,640,768 L,416,768 C,399,768,384,753,384,736 L,384,672 C,384,655,399,640,416,640 L,640,640 L,640,416 C,640,399,655,384,672,384 L,736,384 C,753,384,768,399,768,416 L,768,640 L,992,640 C,1009,640,1024,655,1024,672 M,1152,704 C,1152,457,951,256,704,256 C,457,256,256,457,256,704 C,256,951,457,1152,704,1152 C,951,1152,1152,951,1152,704 M,1664,-128 C,1664,-94,1650,-61,1627,-38 L,1284,305 C,1365,422,1408,562,1408,704 C,1408,1093,1093,1408,704,1408 C,315,1408,0,1093,0,704 C,0,315,315,0,704,0 C,846,0,986,43,1103,124 L,1446,-218 C,1469,-242,1502,-256,1536,-256 C,1607,-256,1664,-199,1664,-128 Z"
		},
		"zoom_out": {
			"advanceWidth": 1664,
			"commands": "M,1024,736 C,1024,753,1009,768,992,768 L,416,768 C,399,768,384,753,384,736 L,384,672 C,384,655,399,640,416,640 L,992,640 C,1009,640,1024,655,1024,672 M,1152,704 C,1152,457,951,256,704,256 C,457,256,256,457,256,704 C,256,951,457,1152,704,1152 C,951,1152,1152,951,1152,704 M,1664,-128 C,1664,-94,1650,-61,1627,-38 L,1284,305 C,1365,422,1408,562,1408,704 C,1408,1093,1093,1408,704,1408 C,315,1408,0,1093,0,704 C,0,315,315,0,704,0 C,846,0,986,43,1103,124 L,1446,-218 C,1469,-242,1502,-256,1536,-256 C,1607,-256,1664,-199,1664,-128 Z"
		},
		"cog": {
			"advanceWidth": 1536,
			"commands": "M,1024,640 C,1024,499,909,384,768,384 C,627,384,512,499,512,640 C,512,781,627,896,768,896 C,909,896,1024,781,1024,640 M,1536,749 C,1536,766,1524,782,1507,785 L,1324,813 C,1314,846,1300,879,1283,911 C,1317,958,1354,1002,1388,1048 C,1393,1055,1396,1062,1396,1071 C,1396,1079,1394,1087,1389,1093 C,1347,1152,1277,1214,1224,1263 C,1217,1269,1208,1273,1199,1273 C,1190,1273,1181,1270,1175,1264 L,1033,1157 C,1004,1172,974,1184,943,1194 L,915,1378 C,913,1395,897,1408,879,1408 L,657,1408 C,639,1408,625,1396,621,1380 C,605,1320,599,1255,592,1194 C,561,1184,530,1171,501,1156 L,363,1263 C,355,1269,346,1273,337,1273 C,303,1273,168,1127,144,1094 C,139,1087,135,1080,135,1071 C,135,1062,139,1054,145,1047 C,182,1002,218,957,252,909 C,236,879,223,849,213,817 L,27,789 C,12,786,0,768,0,753 L,0,531 C,0,514,12,498,29,495 L,212,468 C,222,434,236,401,253,369 C,219,322,182,278,148,232 C,143,225,140,218,140,209 C,140,201,142,193,147,186 C,189,128,259,66,312,18 C,319,11,328,7,337,7 C,346,7,355,10,362,16 L,503,123 C,532,108,562,96,593,86 L,621,-98 C,623,-115,639,-128,657,-128 L,879,-128 C,897,-128,911,-116,915,-100 C,931,-40,937,25,944,86 C,975,96,1006,109,1035,124 L,1173,16 C,1181,11,1190,7,1199,7 C,1233,7,1368,154,1392,186 C,1398,193,1401,200,1401,209 C,1401,218,1397,227,1391,234 C,1354,279,1318,323,1284,372 C,1300,401,1312,431,1323,463 L,1508,491 C,1524,494,1536,512,1536,527 Z"
		}
	}
}
},{}],4:[function(require,module,exports){

var DEFAULT_TIME_SCALE = 60;
var w = Math.max(document.documentElement.clientWidth, window.innerWidth || 0)
var h = Math.max(document.documentElement.clientHeight, window.innerHeight || 0)
// Dimensions
module.exports = {
	LINE_HEIGHT: 26,
	DIAMOND_SIZE: 10,
	MARKER_TRACK_HEIGHT: 60,
	width: w,
	height: h - 100,
	TIMELINE_SCROLL_HEIGHT: 0,
	LEFT_PANE_WIDTH: 250,
	time_scale: DEFAULT_TIME_SCALE, // number of pixels to 1 second
    default_length: 20, // seconds
};

},{}],5:[function(require,module,exports){
module.exports = {
	a: '#343434',
	b: '#535353',
	c: '#b8b8b8',
	d: '#d6d6d6',
};
},{}],6:[function(require,module,exports){
/*
 * @author Joshua Koo http://joshuakoo.com
 */

var Dispatcher = require('./util_dispatcher'),
	Theme = require('./theme'),
	Settings = require('./settings'),
	utils = require('./utils'),
	LayerCabinet = require('./view_layer_cabinet'),
	TimelinePanel = require('./view_panel'),
	package_json = require('../package.json'),
	IconButton = require('./ui_icon_button'),
	style = utils.style,
	STORAGE_PREFIX = utils.STORAGE_PREFIX,
	ScrollBar = require('./ui_scrollbar'),
	DataStore = require('./util_datastore')
	;

var Z_INDEX = 999;

function LayerProp(name) {
	this.name = name;
	this.values = [];

	this._value = 0;
	/*
	this.max
	this.min
	this.step
	*/
}

function Timeliner(target) {
	// Dispatcher for coordination
	var dispatcher = new Dispatcher();

	// Data
	var data = new DataStore();
	var layer_store = data.get('layers');
	var layers = layer_store.value;

	window._data = data; // expose it for debugging

	// Views
	var timeline = new TimelinePanel(data, dispatcher);
	var layer_panel = new LayerCabinet(data, dispatcher);

	dispatcher.on('keyframe', function(layer, value) {
		var index = layers.indexOf(layer);

		var t = data.get('ui:currentTime').value;
		var v = utils.findTimeinLayer(layer, t);

		if (typeof(v) === 'number') {
			layer.values.splice(v, 0, {
				time: t,
				value: value,
			});
		} else {
			console.log('remove from index', v);
			layer.values.splice(v.index, 1);
		}
		repaintAll();
	});
    dispatcher.on('value.change', function(layer, value, dont_save) {
		var t = data.get('ui:currentTime').value;
		var v = utils.findTimeinLayer(layer, t);

		// console.log(v, 'value.change', layer, value, utils.format_friendly_seconds(t), typeof(v));
		if (typeof(v) === 'number') {
			layer.values.splice(v, 0, {
				time: t,
				value: value,
			});

		} else {
			v.object.value = value;

		}

		repaintAll();
	});


	dispatcher.on('ease', function(layer, ease_type) {
		var t = data.get('ui:currentTime').value;
		var v = utils.timeAtLayer(layer, t);
		// console.log('Ease Change > ', layer, value, v);
		if (v && v.entry) {
			v.entry.tween  = ease_type;
		}

		repaintAll();
	});

	var start_play = null,
		played_from = 0; // requires some more tweaking

	var currentTimeStore = data.get('ui:currentTime');
	dispatcher.on('time.update', setCurrentTime);

	dispatcher.on('update.scrollTime', function(v) {
		v = Math.max(0, v);
		data.get('ui:scrollTime').value = v;
		repaintAll();
	});


	function setCurrentTime(value) {
		value = Math.max(0, value);
		currentTimeStore.value = value;

		if (start_play) start_play = performance.now() - value * 1000;
		repaintAll();
		// layer_panel.repaint(s);
	}

	dispatcher.on('target.notify', function(name, value) {
		if (target) target[name] = value;
	});

	dispatcher.on('update.scale', function(v) {
		console.log('range', v);
		data.get('ui:timeScale').value = v;

		timeline.repaint();
	});

	/*
		Paint Routines
	*/

	function paint() {
		requestAnimationFrame(paint);

		if (start_play) {
			var t = (performance.now() - start_play) / 1000;
			setCurrentTime(t);


			if (t > data.get('ui:totalTime').value) {
				// simple loop
				start_play = performance.now();
			}
		}

		if (needsResize) {
			div.style.width = width + 'px';
			div.style.height = height + 'px';

			restyle(layer_panel.dom, timeline.dom);

			timeline.resize();
			repaintAll();
			needsResize = false;

			dispatcher.fire('resize');
		}

		timeline._paint();
	}

	paint();

	function updateState() {
		layers = layer_store.value; // FIXME: support Arrays
		layer_panel.setState(layer_store);
		timeline.setState(layer_store);

		repaintAll();
	}

	function repaintAll() {
		var content_height = layers.length * Settings.LINE_HEIGHT;
		scrollbar.setLength(Settings.TIMELINE_SCROLL_HEIGHT / content_height);

		layer_panel.repaint();
		timeline.repaint();
	}

	dispatcher.on('new', function() {
		data.blank();
		updateState();
	});


	/*
		Start DOM Stuff (should separate file)
	*/

	var div = document.createElement('div');
	div.style.cssText = 'position: absolute;';
	div.style.top = '22px';

	var pane = document.createElement('div');

	style(pane, {
		position: 'fixed',
		top: '20px',
		left: '20px',
		margin: 0,
		border: '1px solid ' + Theme.a,
		padding: 0,
		overflow: 'hidden',
		backgroundColor: Theme.a,
		color: Theme.d,
		zIndex: Z_INDEX,
		fontFamily: 'monospace',
		fontSize: '12px'
	});


	var header_styles = {
		position: 'absolute',
		top: '0px',
		width: '100%',
		height: '22px',
		lineHeight: '22px',
		overflow: 'hidden'
	};

	var button_styles = {
		width: '20px',
		height: '20px',
		padding: '2px',
		marginRight: '2px'
	};

	var pane_title = document.createElement('div');
	style(pane_title, header_styles, {
		borderBottom: '1px solid ' + Theme.b,
		textAlign: 'center'
	});

	var pane_status = document.createElement('div');

	var footer_styles = {
		position: 'absolute',
		width: '100%',
		height: '22px',
		lineHeight: '22px',
		bottom: '0',
		// padding: '2px',
		background: Theme.a,
		fontSize: '11px'
	};

	style(pane_status, footer_styles, {
		borderTop: '1px solid ' + Theme.b,
	});

	pane.appendChild(div);
	pane.appendChild(pane_status);
	pane.appendChild(pane_title);

	var label_status = document.createElement('span');
	label_status.textContent = 'hello!';
	label_status.style.marginLeft = '10px';

	this.setStatus = function(text) {
		label_status.textContent = text;
	};
	dispatcher.on('status', this.setStatus);

	var bottom_right = document.createElement('div');
	style(bottom_right, footer_styles, {
		textAlign: 'right'
	});

	var ghostpane = document.createElement('div');
	ghostpane.id = 'ghostpane';
	style(ghostpane, {
		background: '#999',
		opacity: 0.2,
		position: 'fixed',
		margin: 0,
		padding: 0,
		zIndex: (Z_INDEX - 1),
		// transition: 'all 0.25s ease-in-out',
		transitionProperty: 'top, left, width, height, opacity',
 		transitionDuration: '0.25s',
		transitionTimingFunction: 'ease-in-out'
	});


	pane_status.appendChild(label_status);
	pane_status.appendChild(bottom_right);


	// add layer
	var plus = new IconButton(12, 'plus', 'New Layer', dispatcher);
	plus.onClick(function() {
		var name = prompt('Layer name?');
		addLayer(name);

		repaintAll();
	});
	style(plus.dom, button_styles);
	bottom_right.appendChild(plus.dom);

	var ghostpane = document.createElement('div');
	ghostpane.id = 'ghostpane';
	style(ghostpane, {
		background: '#999',
		opacity: 0.2,
		position: 'fixed',
		margin: 0,
		padding: 0,
		zIndex: (Z_INDEX - 1),
		// transition: 'all 0.25s ease-in-out',
		transitionProperty: 'top, left, width, height, opacity',
 		transitionDuration: '0.25s',
		transitionTimingFunction: 'ease-in-out'
	});


	//
	// Handle DOM Views
	//

	// Shadow Root
	var root = document.createElement('timeliner');
	document.body.appendChild(root);
	if (root.createShadowRoot) root = root.createShadowRoot();

	window.r = root;

	// var iframe = document.createElement('iframe');
	// document.body.appendChild(iframe);
	// root = iframe.contentDocument.body;

	root.appendChild(pane);
	root.appendChild(ghostpane);

	div.appendChild(layer_panel.dom);
	div.appendChild(timeline.dom);

	var scrollbar = new ScrollBar(200, 10);
	div.appendChild(scrollbar.dom);

	// percentages
	scrollbar.onScroll.do(function(type, scrollTo) {
		switch(type) {
			case 'scrollto':
				layer_panel.scrollTo(scrollTo);
				timeline.scrollTo(scrollTo);
				break;
		}
	});

	document.addEventListener('keydown', function(e) {
		var play = e.keyCode == 32; // space
		var enter = e.keyCode == 13; //

		var active = document.activeElement;
		// console.log( active.nodeName );

		if (active.nodeName.match(/(INPUT|BUTTON|SELECT|TIMELINER)/)) {
			active.blur();
		}
	});

	var needsResize = true;

	function resize(width, height) {
		// data.get('ui:bounds').value = {
		// 	width: width,
		// 	height: height
		// };
		// TODO: remove ugly hardcodes
		width -= 4;
		height -= 44;

		Settings.width = width - Settings.LEFT_PANE_WIDTH;
		Settings.height = height;

		Settings.TIMELINE_SCROLL_HEIGHT = height - Settings.MARKER_TRACK_HEIGHT;
		var scrollable_height = Settings.TIMELINE_SCROLL_HEIGHT;

		scrollbar.setHeight(scrollable_height - 2);
		// scrollbar.setThumb

		style(scrollbar.dom, {
			top: Settings.MARKER_TRACK_HEIGHT + 'px',
			left: (width - 16) + 'px',
		});

		needsResize = true;
	}

	function restyle(left, right) {
		left.style.cssText = 'position: absolute; left: 0px; top: 0px; height: ' + Settings.height + 'px;';
		style(left, {
			overflow: 'hidden'
		});
		left.style.width = Settings.LEFT_PANE_WIDTH + 'px';

		right.style.position = 'absolute';
		right.style.top = '0px';
		right.style.left = Settings.LEFT_PANE_WIDTH + 'px';
	}

	function addLayer(name) {
		var layer = new LayerProp(name);

		layers = layer_store.value;
		layers.push(layer);

		layer_panel.setState(layer_store);
	}

	this.addLayer = addLayer;

	this.setTarget = function(t) {
		timeline = t;
	};

	function getValueRanges(ranges, interval) {
		interval = interval ? interval : 0.15;
		ranges = ranges ? ranges : 2;

		// not optimized!
		var t = data.get('ui:currentTime').value;

		var values = [];

		for (var u = -ranges; u <= ranges; u++) {
			// if (u == 0) continue;
			var o = {};

			for (var l = 0; l < layers.length; l++) {
				var layer = layers[l];
				var m = utils.timeAtLayer(layer, t + u * interval);
				o[layer.name] = m.value;
			}

			values.push(o);

		}

		return values;
	}

	this.getValues = getValueRanges;

	(function DockingWindow() {
		"use strict";

		// Minimum resizable area
		var minWidth = 100;
		var minHeight = 80;

		// Thresholds
		var FULLSCREEN_MARGINS = 2;
		var SNAP_MARGINS = 8;
		var MARGINS = 2;

		// End of what's configurable.

		var clicked = null;
		var onRightEdge, onBottomEdge, onLeftEdge, onTopEdge;

		var preSnapped;

		var b, x, y;

		var redraw = false;

		// var pane = document.getElementById('pane');
		// var ghostpane = document.getElementById('ghostpane');

		var mouseOnTitle = false;
		var snapType;

		pane_title.addEventListener('mouseover', function() {
			mouseOnTitle = true;
		});

		pane_title.addEventListener('mouseout', function() {
			mouseOnTitle = false;
		});

		window.addEventListener('resize', function() {
			if (snapType)
				resizeEdges();
			else
				needsResize = true;
		});

		// utils
		function setBounds(element, x, y, w, h) {
			element.style.left = x + 'px';
			element.style.top = y + 'px';
			element.style.width = w + 'px';
			element.style.height = h + 'px';

			if (element === pane) {
				resize(w, h);
			}
		}

		function hintHide() {
			setBounds(ghostpane, b.left, b.top, b.width, b.height);
			ghostpane.style.opacity = 0;
		}

		setBounds(pane, 0, 0, Settings.width, Settings.height);
		setBounds(ghostpane, 0, 0, Settings.width, Settings.height);

		// Mouse events
		pane.addEventListener('mousedown', onMouseDown);
		document.addEventListener('mousemove', onMove);
		document.addEventListener('mouseup', onUp);

		// Touch events
		pane.addEventListener('touchstart', onTouchDown);
		document.addEventListener('touchmove', onTouchMove);
		document.addEventListener('touchend', onTouchEnd);


		function onTouchDown(e) {
			onDown(e.touches[0]);
			e.preventDefault();
		}

		function onTouchMove(e) {
			onMove(e.touches[0]);
		}

		function onTouchEnd(e) {
			if (e.touches.length == 0) onUp(e.changedTouches[0]);
		}

		function onMouseDown(e) {
			onDown(e);
		}

		function onDown(e) {
			calc(e);

			var isResizing = onRightEdge || onBottomEdge || onTopEdge || onLeftEdge;
			var isMoving = !isResizing && canMove();

			clicked = {
				x: x,
				y: y,
				cx: e.clientX,
				cy: e.clientY,
				w: b.width,
				h: b.height,
				isResizing: isResizing,
				isMoving: isMoving,
				onTopEdge: onTopEdge,
				onLeftEdge: onLeftEdge,
				onRightEdge: onRightEdge,
				onBottomEdge: onBottomEdge
			};

			if (isResizing || isMoving) {
				e.preventDefault();
				e.stopPropagation();
			}
		}

		function canMove() {
			return mouseOnTitle;
			// return x > 0 && x < b.width && y > 0 && y < b.height
			// && y < 18;
		}

		function calc(e) {
			b = pane.getBoundingClientRect();
			x = e.clientX - b.left;
			y = e.clientY - b.top;

			onTopEdge = y < MARGINS;
			onLeftEdge = x < MARGINS;
			onRightEdge = x >= b.width - MARGINS;
			onBottomEdge = y >= b.height - MARGINS;
		}

		var e; // current mousemove event

		function onMove(ee) {
			e = ee;
			calc(e);

			redraw = true;
		}

		function checks() {


			if (e.clientY < FULLSCREEN_MARGINS) return 'full-screen';

			if (e.clientY < SNAP_MARGINS) return 'snap-top-edge';

			// hintLeft();
			if (e.clientX < SNAP_MARGINS) return 'snap-left-edge';

			// hintRight();
			if (window.innerWidth - e.clientX < SNAP_MARGINS) return 'snap-right-edge';

			// hintBottom();
			if (window.innerHeight- e.clientY < SNAP_MARGINS) return 'snap-bottom-edge';

		}

		function onUp(e) {
			calc(e);

			if (clicked && clicked.isMoving) {
				// Snap
				snapType = checks();
				if (snapType) {
					preSnapped = {
						width: b.width,
						height: b.height
					};
					resizeEdges();
				} else {
					preSnapped = null;
				}

				hintHide();

			}

			clicked = null;

		}
	})();

}

window.Timeliner = Timeliner;

},{"../package.json":2,"./settings":4,"./theme":5,"./ui_icon_button":8,"./ui_scrollbar":10,"./util_datastore":11,"./util_dispatcher":12,"./util_undo":15,"./utils":16,"./view_layer_cabinet":18,"./view_panel":19}],7:[function(require,module,exports){
var handleDrag = require('./util_handle_drag');

function Canvas(w, h) {

	var canvas, ctx, width, height, dpr;

	var canvasItems = [];
	var child;

	function create() {
		canvas = document.createElement('canvas');
		ctx = canvas.getContext('2d');
	}

	function setSize(w, h) {
		width = w;
		height = h;
		dpr = window.devicePixelRatio;
		canvas.width = width * dpr;
		canvas.height = height * dpr;
		canvas.style.width = width + 'px';
		canvas.style.height = height + 'px';

		if (child) child.setSize(w, h);
	}

	function paint(ctx) {
		if (child) {
			if (!child.paint) console.warn('implement repaint()')
			child.paint(ctx);
		}

		var item;
		for (var i = 0; i < canvasItems.length; i++) {
			item = canvasItems[i];
			item.paint()
		}
	}

	function repaint() {
		paint(ctx);
	}

	function add(item) {
		canvasItems.push(item)
	}

	function remove(item) {
		canvasItems.splice(canvasItems.indexOf(item), 1);
	}

	function uses(c) {
		child = c;
		child.add = this.add;
		child.remove = this.remove;
	}

	create();
	setSize(w, h);
	this.setSize = setSize;
	this.repaint = repaint;
	this.uses = uses;

	this.dom = canvas;

	handleDrag(canvas,
		function down(e) {
			if (child.onDown) { child.onDown(e) };
		},
		function move(e) {
			if (child.onMove) { child.onMove(e) };
		},
		function up(e) {
			if (child.onUp) { child.onUp(e) };
		}
		// function hit(e) {
		// 	if (child.onHit) { child.onHit(e) };
		// }
	);
}


module.exports = Canvas;

/*
 * Usage: canvas = new Canvas(width, height);
 * canvas.resize();
 */

// children
// 1: override repaint
// 2: add objects
// Canvas.uses(CanvasChild);
// CanvasItem
// width, height, x, y
// allow Drag
// allow Click
// mouseOver
//


},{"./util_handle_drag":13}],8:[function(require,module,exports){
var font = require('./font.json'),
	Theme = require('./theme'),
	style = require('./utils').style;

var dp;

function IconButton(size, icon, tooltip, dp) {
	var iconStyle = {
		padding: '0.2em 0.4em',
		margin: '0em',
		background: 'none',
		outline: 'none',
		fontSize: '16px',
		border: 'none',
		borderRadius: '0.2em',
	};

	var button = document.createElement('button');
	style(button, iconStyle);

	var canvas = document.createElement('canvas');
	var ctx = canvas.getContext('2d');

	button.appendChild(canvas);

	this.ctx = ctx;
	this.dom = button;
	this.canvas = canvas;

	var me = this;
	this.size = size;
	var dpr = 1;

	this.resize = function() {
		dpr = window.devicePixelRatio;
		var height = size;

		var glyph = font.fonts[icon];

		canvas.height = height * dpr;
		canvas.style.height = height + 'px';

		var scale = height / font.unitsPerEm;
		var width = glyph.advanceWidth * scale + 0.5 | 0;

		width += 2;
		height += 2;

		canvas.width = width * dpr;
		canvas.style.width = width + 'px';

		ctx.fillStyle = Theme.c;
		me.draw();
	};

	if (dp) dp.on('resize', this.resize);

	this.setSize = function(s) {
		size = s;
		this.resize();
	};

	this.setIcon = function(icon) {
		me.icon = icon;

		if (!font.fonts[icon]) console.warn('Font icon not found!');
		this.resize();
	};

	this.onClick = function(e) {
		button.addEventListener('click', e);
	};

	var LONG_HOLD_DURATION = 500;
	var longHoldTimer;

	this.onLongHold = function(f) {
		// not most elagent but oh wells.
		function startHold(e) {
			e.preventDefault();
			e.stopPropagation();
			longHoldTimer = setTimeout(function() {
				if (longHoldTimer) {
					console.log('LONG HOLD-ED!');
					f();
				}
			}, LONG_HOLD_DURATION);
		}

		function clearLongHoldTimer() {
			clearTimeout(longHoldTimer);
		}

		button.addEventListener('mousedown', startHold);
		button.addEventListener('touchstart', startHold);
		button.addEventListener('mouseup', clearLongHoldTimer);
		button.addEventListener('mouseout', clearLongHoldTimer);
		button.addEventListener('touchend', clearLongHoldTimer);
	};

	this.setTip = function(tip) {
		tooltip = tip;
	};

	var borders = {
		border: '1px solid ' + Theme.b,
		// boxShadow: Theme.b + ' 1px 1px'
	};

	var no_borders = {
		border: '1px solid transparent',
		// boxShadow: 'none'
	};

	var normal = 'none'; // Theme.b;
	var up = Theme.c;
	var down = Theme.b;

	button.style.background = normal;
	style(button, no_borders);

	button.addEventListener('mouseover', function() {
		// button.style.background = up;
		style(button, borders);

		ctx.fillStyle = Theme.d;
		// me.dropshadow = true;
		ctx.shadowColor = Theme.b;
		ctx.shadowBlur = 0.5 * dpr;
		ctx.shadowOffsetX = 1 * dpr;
		ctx.shadowOffsetY = 1 * dpr;
		me.draw();

		if (tooltip && dp) dp.fire('status', 'button: ' + tooltip);
	});

	button.addEventListener('mousedown', function() {
		button.style.background = down;
		// ctx.fillStyle = Theme.b;
		// me.draw();
	});

	button.addEventListener('mouseup', function() {
		// ctx.fillStyle = Theme.d;
		button.style.background = normal;
		style(button, borders);
		// me.draw();
	});

	button.addEventListener('mouseout', function() {
		// ctx.fillStyle = Theme.c;


		button.style.background = normal;
		style(button, no_borders);
		me.dropshadow = false;
		ctx.fillStyle = Theme.c;
		ctx.shadowColor = null;
		ctx.shadowBlur = 0;
		ctx.shadowOffsetX = 0;
		ctx.shadowOffsetY = 0;
		me.draw();
	});

	if (icon) this.setIcon(icon);
}

IconButton.prototype.CMD_MAP = {
	M: 'moveTo',
	L: 'lineTo',
	Q: 'quadraticCurveTo',
	C: 'bezierCurveTo',
	Z: 'closePath'
};

IconButton.prototype.draw = function() {
	if (!this.icon) return;

	var ctx = this.ctx;

	var glyph = font.fonts[this.icon];

	var height = this.size;
	var dpr = window.devicePixelRatio;
	var scale = height / font.unitsPerEm * dpr;
	var path_commands =  glyph.commands.split(' ');

	ctx.save();
	ctx.clearRect(0, 0, this.canvas.width * dpr, this.canvas.height * dpr);

	if (this.dropshadow) {
		ctx.save();
		ctx.fillStyle = Theme.b;
		ctx.translate(1.5 * dpr, 1.5 * dpr);
		ctx.scale(scale, -scale);
		ctx.translate(0 , -font.ascender);
		ctx.beginPath();

		for (var i = 0, il = path_commands.length; i < il; i++) {
			var cmds = path_commands[i].split(',');
			var params = cmds.slice(1);

			ctx[this.CMD_MAP[cmds[0]]].apply(ctx, params);
		}
		ctx.fill();
		ctx.restore();
	}

	ctx.scale(scale, -scale);
	ctx.translate(0, -font.ascender);
	ctx.beginPath();

	for (var i = 0, il = path_commands.length; i < il; i++) {
		var cmds = path_commands[i].split(',');
		var params = cmds.slice(1);

		ctx[this.CMD_MAP[cmds[0]]].apply(ctx, params);
	}
	ctx.fill();
	ctx.restore();
};

module.exports = IconButton;
},{"./font.json":3,"./theme":5,"./utils":16}],9:[function(require,module,exports){
var Theme = require('./theme'),
	Do = require('do.js'),
	handleDrag = require('./util_handle_drag'),
	style = require('./utils').style,
	firstDefined = require('./utils').firstDefined
	;

/**************************/
// NumberUI
/**************************/

function NumberUI(config) {
	config = config || {};
	var min = config.min === undefined ? -Infinity : config.min;

	// config.xstep and config.ystep allow configuring adjustment
	// speed across each axis.
	// config.wheelStep and config.wheelStepFine allow configuring
	// adjustment speed for mousewheel, and mousewheel while holding <alt>

	// If only config.step is specified, all other adjustment speeds
	// are set to the same value.
	var xstep = firstDefined(config.xstep, config.step, 0.001);
	var ystep = firstDefined(config.ystep, config.step, 0.1);
	var wheelStep = firstDefined(config.wheelStep, ystep);
	var wheelStepFine = firstDefined(config.wheelStepFine, xstep);

	var precision = config.precision || 3;
	// Range
	// Max

	var span = document.createElement('input');
	// span.type = 'number'; // spinner

	style(span, {
		textAlign: 'center',
		fontSize: '10px',
		padding: '1px',
		cursor: 'ns-resize',
		width: '40px',
		margin: 0,
		marginRight: '10px',
		appearance: 'none',
		outline: 'none',
		border: 0,
		background: 'none',
		borderBottom: '1px dotted '+ Theme.c,
		color: Theme.c
	});

	var me = this;
	var state, value = 0, unchanged_value;

	this.onChange = new Do();

	span.addEventListener('change', function(e) {
		console.log('input changed', span.value);
		value = parseFloat(span.value, 10);

		fireChange();
	});

	// Allow keydown presses in inputs, don't allow parent to block them
	span.addEventListener('keydown', function(e) {
		e.stopPropagation();
	})

	span.addEventListener('focus', function(e) {
		span.setSelectionRange(0, span.value.length);
	})

	span.addEventListener('wheel', function(e) {
		// Disregard pixel/line/page scrolling and just
		// use event direction.
		var inc = e.deltaY > 0? 1 : -1;
		if(e.altKey) {
			inc *= wheelStepFine;
		} else {
			inc *= wheelStep;
		}
		value = clamp(value + inc);
		fireChange();
	})

	handleDrag(span, onDown, onMove, onUp);

	function clamp(value) {
		return Math.max(min, value);
	}

	function onUp(e) {
		if (e.moved) fireChange();
		else {
			// single click
			span.focus();
		}
	}

	function onMove(e) {
		var dx = e.dx;
		var dy = e.dy;

		value = unchanged_value + (dx * xstep) + (dy * -ystep);

		value = clamp(value);

		// value = +value.toFixed(precision); // or toFixed toPrecision
		me.onChange.fire(value, true);
	}

	function onDown(e) {
		unchanged_value = value;
	}

	function fireChange() {
		me.onChange.fire(value);
	}

	this.dom = span;

	// public
	this.setValue = function(v) {
		value = v;
		span.value = value.toFixed(precision);
	};

	this.paint = function() {
		if (value && document.activeElement !== span) {
			span.value = value.toFixed(precision);
		}
	};
}

module.exports = NumberUI;

},{"./theme":5,"./util_handle_drag":13,"./utils":16,"do.js":1}],10:[function(require,module,exports){
var SimpleEvent = require('do.js');
var utils = require('./utils');

// ********** class: ScrollBar ****************** //
/*
	Simple UI widget that displays a scrolltrack
	and slider, that fires some scroll events
*/
// ***********************************************

var scrolltrack_style = {
	// float: 'right',
	position: 'absolute',
	// right: '0',
	// top: '0',
	// bottom: '0',
	background: '-webkit-gradient(linear, left top, right top, color-stop(0, rgb(29,29,29)), color-stop(0.6, rgb(50,50,50)) )',
	border: '1px solid rgb(29, 29, 29)',
	// zIndex: '1000',
	textAlign: 'center',
	cursor: 'pointer'
};

var scrollbar_style = {
	background: '-webkit-gradient(linear, left top, right top, color-stop(0.2, rgb(88,88,88)), color-stop(0.6, rgb(64,64,64)) )',
	border: '1px solid rgb(25,25,25)',
	// position: 'absolute',
	position: 'relative',
	borderRadius: '6px'
};

function ScrollBar(h, w, dispatcher) {

	var SCROLLBAR_WIDTH = w ? w : 12;
	var SCROLLBAR_MARGIN = 3;
	var SCROLL_WIDTH = SCROLLBAR_WIDTH + SCROLLBAR_MARGIN * 2;
	var MIN_BAR_LENGTH = 25;

	var scrolltrack = document.createElement('div');
	utils.style(scrolltrack, scrolltrack_style);

	var scrolltrackHeight = h - 2;
	scrolltrack.style.height = scrolltrackHeight + 'px';
	scrolltrack.style.width = SCROLL_WIDTH + 'px';;

	// var scrollTop = 0;
	var scrollbar = document.createElement('div');
	// scrollbar.className = 'scrollbar';
	utils.style(scrollbar, scrollbar_style);
	scrollbar.style.width = SCROLLBAR_WIDTH + 'px';
	scrollbar.style.height = h / 2;
	scrollbar.style.top = 0;
	scrollbar.style.left = SCROLLBAR_MARGIN + 'px'; // 0; //S

	scrolltrack.appendChild(scrollbar);

	var me = this;

	var bar_length, bar_y;

	// Sets lengths of scrollbar by percentage
	this.setLength = function(l) {
		// limit 0..1
		l = Math.max(Math.min(1, l), 0);
		l *= scrolltrackHeight;
		bar_length = Math.max(l, MIN_BAR_LENGTH);
		scrollbar.style.height = bar_length + 'px';
	};

	this.setHeight = function(height) {
		h = height;

		scrolltrackHeight = h - 2;
		scrolltrack.style.height = scrolltrackHeight + 'px' ;
	};

	// Moves scrollbar to position by Percentage
	this.setPosition = function(p) {
		p = Math.max(Math.min(1, p), 0);
		var emptyTrack = scrolltrackHeight - bar_length;
		bar_y = p * emptyTrack;
		scrollbar.style.top = bar_y + 'px';
	};

	this.setLength(1);
	this.setPosition(0);
	this.onScroll = new SimpleEvent();

	var mouse_down_grip;

	function onDown(event) {
		event.preventDefault();

		if (event.target == scrollbar) {
			mouse_down_grip = event.clientY;
			document.addEventListener('mousemove', onMove, false);
			document.addEventListener('mouseup', onUp, false);
		} else {
			if (event.clientY < bar_y) {
				me.onScroll.fire('pageup');
			} else if (event.clientY > (bar_y + bar_length)) {
				me.onScroll.fire('pagedown');
			}
			// if want to drag scroller to empty track instead
			// me.setPosition(event.clientY / (scrolltrackHeight - 1));
		}
	}

	function onMove(event) {
		event.preventDefault();

		// event.target == scrollbar
		var emptyTrack = scrolltrackHeight - bar_length;
		var scrollto = (event.clientY - mouse_down_grip) / emptyTrack;

		// clamp limits to 0..1
		if (scrollto > 1) scrollto = 1;
		if (scrollto < 0) scrollto = 0;
		me.setPosition(scrollto);
		me.onScroll.fire('scrollto', scrollto);
	}

	function onUp(event) {
		onMove(event);
		document.removeEventListener('mousemove', onMove, false);
		document.removeEventListener('mouseup', onUp, false);
	}

	scrolltrack.addEventListener('mousedown', onDown, false);
	this.dom = scrolltrack;

}

module.exports = ScrollBar;
},{"./utils":16,"do.js":1}],11:[function(require,module,exports){
var package_json = require('../package.json'),
	Settings = require('./settings'),
	Do = require('do.js');

// Data Store with a source of truth
function DataStore() {
	this.DELIMITER = ':';
	this.blank();

	this.listeners = [];
}

DataStore.prototype.addListener = function(path, cb) {
	this.listeners.push({
		path: path,
		callback: cb
	});
};

DataStore.prototype.blank = function() {
	var data = {};

	data.version = package_json.version;
	data.modified = new Date().toString();
	data.title = 'Untitled';

	data.ui = {
		currentTime: 0,
		totalTime: Settings.default_length,
		scrollTime: 0,
		timeScale: Settings.time_scale
	};

	data.layers = [];

	this.data = data;
};

DataStore.prototype.update = function() {
	var data = this.data;

	data.version = package_json.version;
	data.modified = new Date().toString();
};

DataStore.prototype.setJSONString = function(data) {
	this.data = JSON.parse(data);
};

DataStore.prototype.setJSON = function(data) {
	this.data = data;
};

DataStore.prototype.getJSONString = function(format) {
	return JSON.stringify(this.data, null, format);
};

DataStore.prototype.getValue = function(paths) {
	var descend = paths.split(this.DELIMITER);
	var reference = this.data;
	for (var i = 0, il = descend.length; i < il; i++) {
		var path = descend[i];
		if (reference[path] === undefined) {
			console.warn('Cant find ' + paths);
			return;
		}
		reference = reference[path];
	}
	return reference;
};

DataStore.prototype.setValue = function(paths, value) {
	var descend = paths.split(this.DELIMITER);
	var reference = this.data;
	for (var i = 0, il = descend.length - 1; path = descend[i], i < il ; i++) {
		reference = reference[path];
	}

	reference[path] = value;

	this.listeners.forEach(function(l) {
		if (paths.indexOf(l.path) > -1) l.callback();
	})
};

DataStore.prototype.get = function(path, suffix) {
	if (suffix) path = suffix + this.DELIMITER + path;
	return new DataProx(this, path);
};

function DataProx(store, path) {
	this.path = path;
	this.store = store;
}

DataProx.prototype = {
	get value() {
		return this.store.getValue(this.path);
	},
	set value(val) {
		this.store.setValue(this.path, val);
	}
};

DataProx.prototype.get = function(path) {
	return this.store.get(path, this.path);
};

module.exports = DataStore;

},{"../package.json":2,"./settings":4,"do.js":1}],12:[function(require,module,exports){
/**************************/
// Dispatcher
/**************************/

function Dispatcher() {

	var event_listeners = {

	};

	function on(type, listener) {
		if (!(type in event_listeners)) {
			event_listeners[type] = [];
		}
		var listeners = event_listeners[type];
		listeners.push(listener);
	}

	function fire(type) {
		var args = Array.prototype.slice.call(arguments);
		args.shift();
		var listeners = event_listeners[type];
		if (!listeners) return;
		for (var i = 0; i < listeners.length; i++) {
			var listener = listeners[i];
			listener.apply(listener, args);
		}
	}

	this.on = on;
	this.fire = fire;

}

module.exports = Dispatcher;
},{}],13:[function(require,module,exports){
function handleDrag(element, ondown, onmove, onup, down_criteria) {
	var pointer = null;
	var bounds = element.getBoundingClientRect();

	element.addEventListener('mousedown', onMouseDown);

	function onMouseDown(e) {
		handleStart(e);

		if (down_criteria && !down_criteria(pointer)) {
			pointer = null;
			return;
		}


		document.addEventListener('mousemove', onMouseMove);
		document.addEventListener('mouseup', onMouseUp);

		ondown(pointer);

		e.preventDefault();
	}

	function onMouseMove(e) {
		handleMove(e);
		onmove(pointer);
	}

	function handleStart(e) {
		bounds = element.getBoundingClientRect();
		var currentx = e.clientX, currenty = e.clientY;
		pointer = {
			startx: currentx,
			starty: currenty,
			x: currentx,
			y: currenty,
			dx: 0,
			dy: 0,
			offsetx: currentx - bounds.left,
			offsety: currenty - bounds.top,
			moved: false
		};
	}

	function handleMove(e) {
		bounds = element.getBoundingClientRect();
		var currentx = e.clientX,
		currenty = e.clientY,
		offsetx = currentx - bounds.left,
		offsety = currenty - bounds.top;
		pointer.x = currentx;
		pointer.y = currenty;
		pointer.dx = e.clientX - pointer.startx;
		pointer.dy = e.clientY - pointer.starty;
		pointer.offsetx = offsetx;
		pointer.offsety = offsety;

		// If the pointer dx/dy is _ever_ non-zero, then it's moved
		pointer.moved = pointer.moved || pointer.dx !== 0 || pointer.dy !== 0;
	}

	function onMouseUp(e) {
		handleMove(e);
		onup(pointer);
		pointer = null;

		document.removeEventListener('mousemove', onMouseMove);
		document.removeEventListener('mouseup', onMouseUp);
	}

	element.addEventListener('touchstart', onTouchStart);

	function onTouchStart(te) {

		if (te.touches.length == 1) {

			var e = te.touches[0];
			if (down_criteria && !down_criteria(e)) return;
			te.preventDefault();
			handleStart(e);
			ondown(pointer);
		}

		element.addEventListener('touchmove', onTouchMove);
		element.addEventListener('touchend', onTouchEnd);
	}

	function onTouchMove(te) {
		var e = te.touches[0];
		onMouseMove(e);
	}

	function onTouchEnd(e) {
		// var e = e.touches[0];
		onMouseUp(e);
		element.removeEventListener('touchmove', onTouchMove);
		element.removeEventListener('touchend', onTouchEnd);
	}


	this.release = function() {
		element.removeEventListener('mousedown', onMouseDown);
		element.removeEventListener('touchstart', onTouchStart);
	};
}

module.exports = handleDrag;

},{}],14:[function(require,module,exports){
/**************************/
// Tweens
/**************************/

var Tweens = {
	linear: function(k) {
		return k;
	}
};

module.exports = Tweens;
},{}],15:[function(require,module,exports){

module.exports = {

};
},{}],16:[function(require,module,exports){
var
	Tweens = require('./util_tween');

module.exports = {
	STORAGE_PREFIX: 'timeliner-',
	Z_INDEX: 999,
	firstDefined: firstDefined,
	style: style,
	format_friendly_seconds: format_friendly_seconds,
	findTimeinLayer: findTimeinLayer,
	timeAtLayer: timeAtLayer,
	proxy_ctx: proxy_ctx
};

/**************************/
// Utils
/**************************/

function firstDefined() {
	for(var i = 0; i < arguments.length; i++) {
		if(typeof arguments[i] !== 'undefined') {
			return arguments[i];
		}
	}
	return undefined;
}

function style(element, var_args) {
	for (var i = 1; i < arguments.length; ++i) {
		var styles = arguments[i];
		for (var s in styles) {
			element.style[s] = styles[s];
		}
	}
}


var input;

function fakeClick(target) {
	var e = document.createEvent("MouseEvents");
	e.initMouseEvent(
		'click', true, false, window, 0, 0, 0, 0, 0,
		false, false, false, false, 0, null
	);
	target.dispatchEvent(e);
}

function format_friendly_seconds(s, type) {
	// TODO Refactor to 60fps???
	// 20 mins * 60 sec = 1080
	// 1080s * 60fps = 1080 * 60 < Number.MAX_SAFE_INTEGER

	var raw_secs = s | 0;
	var secs_micro = s % 60;
	var secs = raw_secs % 60;
	var raw_mins = raw_secs / 60 | 0;
	var mins = raw_mins % 60;
	var hours = raw_mins / 60 | 0;

	var secs_str = (secs / 100).toFixed(2).substring(2);

	var str = mins + ':' + secs_str;

	if (s % 1 > 0) {
		var t2 = (s % 1) * 60;
		if (type === 'frames') str = secs + '+' + t2.toFixed(0) + 'f';
		else str += ((s % 1).toFixed(2)).substring(1);
		// else str = mins + ':' + secs_micro;
		// else str = secs_micro + 's'; /// .toFixed(2)
	}
	return str;
}

// get object at time
function findTimeinLayer(layer, time) {
	var values = layer.values;
	var i, il;

	// TODO optimize by checking time / binary search

	for (i=0, il=values.length; i<il; i++) {
		var value = values[i];
		if (value.time === time) {
			return {
				index: i,
				object: value
			};
		} else if (value.time > time) {
			return i;
		}
	}

	return i;
}


function timeAtLayer(layer, t) {
	// Find the value of layer at t seconds.
	// this expect layer to be sorted
	// not the most optimized for now, but would do.

	var values = layer.values;
	var i, il, entry, prev_entry;

	il = values.length;

	// can't do anything
	if (il === 0) return;

	// find boundary cases
	entry = values[0];
	if (t < entry.time) {
		return {
			value: entry.value,
			can_tween: false, // cannot tween
			keyframe: false // not on keyframe
		};
	}

	for (i=0; i<il; i++) {
		prev_entry = entry;
		entry = values[i];

		if (t === entry.time) {
			// only exception is on the last KF, where we display tween from prev entry
			if (i === il - 1) {
				return {
					// index: i,
					entry: prev_entry,
					tween: prev_entry.tween,
					can_tween: il > 1,
					value: entry.value,
					keyframe: true
				};
			}
			return {
				// index: i,
				entry: entry,
				tween: entry.tween,
				can_tween: il > 1,
				value: entry.value,
				keyframe: true // il > 1
			};
		}
		if (t < entry.time) {
			// possibly a tween
			if (!prev_entry.tween) { // or if value is none
				return {
					value: prev_entry.value,
					tween: false,
					entry: prev_entry,
					can_tween: true,
					keyframe: false
				};
			}

			// calculate tween
			var time_diff = entry.time - prev_entry.time;
			var value_diff = entry.value - prev_entry.value;
			var tween = prev_entry.tween;

			var dt = t - prev_entry.time;
			var k = dt / time_diff;
			var new_value = prev_entry.value + Tweens[tween](k) * value_diff;

			return {
				entry: prev_entry,
				value: new_value,
				tween: prev_entry.tween,
				can_tween: true,
				keyframe: false
			};
		}
	}
	// time is after all entries
	return {
		value: entry.value,
		can_tween: false,
		keyframe: false
	};

}


function proxy_ctx(ctx) {
	// Creates a proxy 2d context wrapper which
	// allows the fluent / chaining API.
	var wrapper = {};

	function proxy_function(c) {
		return function() {
			// Warning: this doesn't return value of function call
			ctx[c].apply(ctx, arguments);
			return wrapper;
		};
	}

	function proxy_property(c) {
		return function(v) {
			ctx[c] = v;
			return wrapper;
		};
	}

	wrapper.run = function(args) {
		args(wrapper);
		return wrapper;
	};

	for (var c in ctx) {
		// if (!ctx.hasOwnProperty(c)) continue;
		// console.log(c, typeof(ctx[c]), ctx.hasOwnProperty(c));
		// string, number, boolean, function, object

		var type = typeof(ctx[c]);
		switch(type) {
			case 'object':
				break;
			case 'function':
				wrapper[c] = proxy_function(c);
				break;
			default:
				wrapper[c] = proxy_property(c);
				break;
		}
	}

	return wrapper;
}

},{"./util_tween":14}],17:[function(require,module,exports){
var
	Theme = require('./theme'),
	UINumber = require('./ui_number'),
	Tweens = require('./util_tween'),
	Settings = require('./settings'),
	utils = require('./utils')
;

// TODO - tagged by index instead, work off layers.

function LayerView(layer, dispatcher) {
	var dom = document.createElement('div');

    	var label = document.createElement('span');

    	label.style.cssText = 'font-size: 12px; padding: 4px;';

    	var dropdown = document.createElement('select');
    	var option;
    	dropdown.style.cssText = 'font-size: 10px; width: 60px; margin: 0; float: right; text-align: right;';

    	for (var k in Tweens) {
    		option = document.createElement('option');
    		option.text = k;
    		dropdown.appendChild(option);
    	}

    	dropdown.addEventListener('change', function(e) {
    		dispatcher.fire('ease', layer, dropdown.value);
    	});

    	var keyframe_button = document.createElement('button');
    	keyframe_button.innerHTML = '&#9672;'; // '&diams;' &#9671; 9679 9670 9672
    	keyframe_button.style.cssText = 'background: none; font-size: 12px; padding: 0px; font-family: monospace; float: right; width: 20px; border-style:none; outline: none;'; //  border-style:inset;

    	keyframe_button.addEventListener('click', function(e) {
    		console.log('clicked:keyframing...', state.get('_value').value);
    		dispatcher.fire('keyframe', layer, state.get('_value').value);
    	});

    	var number = new UINumber(layer, dispatcher);

    	number.onChange.do(function(value, done) {
    		state.get('_value').value = value;
    		dispatcher.fire('value.change', layer, value, done);
    	});

    	utils.style(number.dom, {
    		float: 'right'
    	});

    	dom.appendChild(label);
    	dom.appendChild(keyframe_button);
    	dom.appendChild(number.dom);
    	dom.appendChild(dropdown);

    	dom.style.cssText = 'margin: 0px; border-bottom:1px solid ' + Theme.b + '; top: 0; left: 0; height: ' + (Settings.LINE_HEIGHT ) + 'px; color: ' + Theme.c;
    	this.dom = dom;

    	this.repaint = repaint;
    	var state;

    	this.setState = function(l, s) {
    		layer = l;
    		state = s;

    		var tmp_value = state.get('_value');
    		if (tmp_value.value === undefined) {
    			tmp_value.value = 0;
    		}

    		number.setValue(tmp_value.value);
    		label.textContent = state.get('name').value;

    		repaint();
    	};

	function repaint(s) {

		dropdown.style.opacity = 0;
		dropdown.disabled = true;
		keyframe_button.style.color = Theme.b;
		// keyframe_button.disabled = false;
		// keyframe_button.style.borderStyle = 'solid';

		var tween = null;
		var o = utils.timeAtLayer(layer, s);

		if (!o) return;

		if (o.can_tween) {
			dropdown.style.opacity = 1;
			dropdown.disabled = false;
			// if (o.tween)
			dropdown.value = o.tween ? o.tween : 'none';
			if (dropdown.value === 'none') dropdown.style.opacity = 0.5;
		}

		if (o.keyframe) {
			keyframe_button.style.color = Theme.c;
			// keyframe_button.disabled = true;
			// keyframe_button.style.borderStyle = 'inset';
		}

		state.get('_value').value = o.value;
		number.setValue(o.value);
		number.paint();

		dispatcher.fire('target.notify', layer.name, o.value);
	}

}

module.exports = LayerView;

},{"./settings":4,"./theme":5,"./ui_number":9,"./util_tween":14,"./utils":16}],18:[function(require,module,exports){
var Settings = require('./settings'),
	ViewLayer = require('./view_layer'),
	IconButton = require('./ui_icon_button'),
	style = require('./utils').style,
	Theme = require('./theme'),
	STORAGE_PREFIX = require('./utils').STORAGE_PREFIX,
	UINumber = require('./ui_number')
	;

function LayerCabinet(data, dispatcher) {
	var layer_store = data.get('layers');

	var div = document.createElement('div');

	var top = document.createElement('div');
	top.style.cssText = 'margin: 0px; top: 0; left: 0; height: ' + Settings.MARKER_TRACK_HEIGHT + 'px';
	// top.style.textAlign = 'right';

	var layer_scroll = document.createElement('div');
	style(layer_scroll, {
		position: 'absolute',
		top: Settings.MARKER_TRACK_HEIGHT + 'px',
		// height: (Settings.height - Settings.MARKER_TRACK_HEIGHT) + 'px'
		left: 0,
		right: 0,
		bottom: 0,
		overflow: 'hidden'
	});

	div.appendChild(layer_scroll);

	var playing = false;


	var button_styles = {
		width: '22px',
		height: '22px',
		padding: '2px'
	};

	var op_button_styles = {
		width: '32px',
		padding: '3px 4px 3px 4px'
	};

	var range = document.createElement('input');
	range.type = "range";
	range.value = 0;
	range.min = -1;
	range.max = +1;
	range.step = 0.125;

	style(range, {
		width: '90px',
		margin: '0px',
		marginLeft: '2px',
		marginRight: '2px'
	});

	var draggingRange = 0;

	range.addEventListener('mousedown', function() {
		draggingRange = 1;
	});

	range.addEventListener('mouseup', function() {
		draggingRange = 0;
		changeRange();
	});

	range.addEventListener('mousemove', function() {
		if (!draggingRange) return;
		changeRange();
	});

	div.appendChild(top);

	var time_options = {
		min: 0,
		step: 0.125
	};

	var currentTime = new UINumber(time_options);
	var totalTime = new UINumber(time_options);

	var currentTimeStore = data.get('ui:currentTime');
	var totalTimeStore = data.get('ui:totalTime');

	currentTime.onChange.do(function(value, done) {
		dispatcher.fire('time.update', value);
		// repaint();
	});

	totalTime.onChange.do(function(value, done) {
		totalTimeStore.value = value;
		repaint();
	});

	top.appendChild(currentTime.dom);
	top.appendChild(document.createTextNode('/')); // 0:00:00 / 0:10:00
	top.appendChild(totalTime.dom)
	top.appendChild(range);


	var operations_div = document.createElement('div');
	style(operations_div, {
		marginTop: '4px',
		// borderBottom: '1px solid ' + Theme.b
	});
	top.appendChild(operations_div);
	// top.appendChild(document.createElement('br'));

	var span = document.createElement('span');
	span.style.width = '20px';
	span.style.display = 'inline-block';
	operations_div.appendChild(span);
	operations_div.appendChild(document.createElement('br'));

	function convertPercentToTime(t) {
		var min_time = 10 * 60; // 10 minutes
		min_time = data.get('ui:totalTime').value;
		var max_time = 1;
		var v = Settings.width * 0.8 / (t * (max_time - min_time) + min_time);
		return v;
	}

	function convertTimeToPercent(v) {
		var min_time = 10 * 60; // 10 minutes
		min_time = data.get('ui:totalTime').value;
		var max_time = 1;
		var t  = ((Settings.width * 0.8 / v) - min_time)  / (max_time - min_time);
		return t;
	}

	function changeRange() {

		dispatcher.fire('update.scale', Math.pow(100, -range.value) );
	}

	var layer_uis = [], visible_layers = 0;
	var unused_layers = [];

	this.layers = layer_uis;

	this.setState = function(state) {

		layer_store = state;
		layers = layer_store.value;
		// layers = state;
		console.log(layer_uis.length, layers);
		var i, layer;
		for (i = 0; i < layers.length; i++) {
			layer = layers[i];

			if (!layer_uis[i]) {
				var layer_ui;
				if (unused_layers.length) {
					layer_ui = unused_layers.pop();
					layer_ui.dom.style.display = 'block';
				} else {
					// new
					layer_ui = new ViewLayer(layer, dispatcher);
					layer_scroll.appendChild(layer_ui.dom);
				}
				layer_uis.push(layer_ui);
			}

			// layer_uis[i].setState(layer);
		}

		console.log('Total layers (view, hidden, total)', layer_uis.length, unused_layers.length,
			layer_uis.length + unused_layers.length);

	};

	function repaint(s) {

		s = currentTimeStore.value;
		currentTime.setValue(s);
		totalTime.setValue(totalTimeStore.value);
		currentTime.paint();
		totalTime.paint();

		var i;

		s = s || 0;
		for (i = layer_uis.length; i-- > 0;) {
			// quick hack
			if (i >= layers.length) {
				layer_uis[i].dom.style.display = 'none';
				unused_layers.push(layer_uis.pop());
				continue;
			}

			layer_uis[i].setState(layers[i], layer_store.get(i));
			// layer_uis[i].setState('layers'+':'+i);
			layer_uis[i].repaint(s);
		}

		visible_layers = layer_uis.length;

	}

	this.repaint = repaint;
	this.setState(layer_store);

	this.scrollTo = function(x) {
		layer_scroll.scrollTop = x * (layer_scroll.scrollHeight - layer_scroll.clientHeight);
	};

	this.dom = div;

	repaint();
}

module.exports = LayerCabinet;

},{"./settings":4,"./theme":5,"./ui_icon_button":8,"./ui_number":9,"./utils":16,"./view_layer":17}],19:[function(require,module,exports){
var
	Settings = require('./settings'),
	Theme = require('./theme'),
	utils = require('./utils'),
	proxy_ctx = utils.proxy_ctx,
	Tweens = require('./util_tween'),
	handleDrag = require('./util_handle_drag'),
	ScrollCanvas = require('./view_time_scroller'),
	Canvas = require('./ui_canvas')
	;

var
	LINE_HEIGHT = Settings.LINE_HEIGHT,
	DIAMOND_SIZE = Settings.DIAMOND_SIZE,
	TIME_SCROLLER_HEIGHT = 35,
	MARKER_TRACK_HEIGHT = 25,
	LEFT_PANE_WIDTH = Settings.LEFT_PANE_WIDTH,
	time_scale = Settings.time_scale,
	TOP = 10;


var frame_start = 0; // this is the current scroll position.


/*
 * This class contains the view for the right main section of timeliner
 */


// TODO
// dirty rendering
// drag block
// DON'T use time.update for everything

var tickMark1;
var tickMark2;
var tickMark3;

function time_scaled() {
	/*
	 * Subdivison LOD
	 * time_scale refers to number of pixels per unit
	 * Eg. 1 inch - 60s, 1 inch - 60fps, 1 inch - 6 mins
	 */
	var div = 60;

	tickMark1 = time_scale / div;
	tickMark2 = 2 * tickMark1;
	tickMark3 = 10 * tickMark1;

}

time_scaled();


/**************************/
// Timeline Panel
/**************************/

function TimelinePanel(data, dispatcher) {

	var dpr = window.devicePixelRatio;
	var canvas = document.createElement('canvas');

	var scrollTop = 0, scrollLeft = 0, SCROLL_HEIGHT;
	var layers = data.get('layers').value;

	this.scrollTo = function(s, y) {
		scrollTop = s * Math.max(layers.length * LINE_HEIGHT - SCROLL_HEIGHT, 0);
		repaint();
	};

	this.resize = function() {
		var h = (Settings.height - TIME_SCROLLER_HEIGHT);
		dpr = window.devicePixelRatio;
		canvas.width = Settings.width * dpr;
		canvas.height = h * dpr;
		canvas.style.width = Settings.width + 'px';
		canvas.style.height = h + 'px';
		SCROLL_HEIGHT = Settings.height - TIME_SCROLLER_HEIGHT;
		scroll_canvas.setSize(Settings.width, TIME_SCROLLER_HEIGHT);
	};

	var div = document.createElement('div');

	var scroll_canvas = new Canvas(Settings.width, TIME_SCROLLER_HEIGHT);
	// data.addListener('ui', repaint );

	utils.style(canvas, {
		position: 'absolute',
		top: TIME_SCROLLER_HEIGHT + 'px',
		left: '0px'
	});

	utils.style(scroll_canvas.dom, {
		position: 'absolute',
		top: '0px',
		left: '10px'
	});

	scroll_canvas.uses(new ScrollCanvas(dispatcher, data));


	div.appendChild(canvas);
	div.appendChild(scroll_canvas.dom);

	// this.dom = canvas;
	this.dom = div;
	this.resize();

	var ctx = canvas.getContext('2d');
	var ctx_wrap = proxy_ctx(ctx);

	var currentTime; // measured in seconds
	// technically it could be in frames or  have it in string format (0:00:00:1-60)

	var LEFT_GUTTER = 20;
	var i, x, y, il, j;

	var needsRepaint = false;
	var renderItems = [];

	function EasingRect(x1, y1, x2, y2, frame, frame2, values, layer, j) {
		var self = this;

		this.path = function() {
			ctx_wrap.beginPath()
			.rect(x1, y1, x2-x1, y2-y1)
			.closePath();
		};

		this.paint = function() {
			this.path();
			ctx.fillStyle = "#355ce8";
			ctx.fill();
            ctx.font = "12px Arial";
            ctx.textAlign = "left";
            ctx.fillStyle = 'black';
			ctx.fillText("Hello World", x1, y2);
		};

		this.mouseover = function() {
			canvas.style.cursor = 'pointer'; // pointer move ew-resize
		};

		this.mouseout = function() {
			canvas.style.cursor = 'default';
		};

		this.mousedrag = function(e) {
			var t1 = x_to_time(x1 + e.dx);
			t1 = Math.max(0, t1);
			// TODO limit moving to neighbours
			frame.time = t1;

			var t2 = x_to_time(x2 + e.dx);
			t2 = Math.max(0, t2);
			frame2.time = t2;

			// dispatcher.fire('time.update', t1);
		};
	}

	function Diamond(frame, y) {
		var x, y2;

		x = time_to_x(frame.time);
		y2 = y + LINE_HEIGHT * 0.5  - DIAMOND_SIZE / 2;

		var self = this;

		var isOver = false;

		this.path = function(ctx_wrap) {
			ctx_wrap
				.beginPath()
				.moveTo(x, y2)
				.lineTo(x + DIAMOND_SIZE / 2, y2 + DIAMOND_SIZE / 2)
				.lineTo(x, y2 + DIAMOND_SIZE)
				.lineTo(x - DIAMOND_SIZE / 2, y2 + DIAMOND_SIZE / 2)
				.closePath();
		};

		this.paint = function(ctx_wrap) {
			self.path(ctx_wrap);
			if (!isOver)
				ctx_wrap.fillStyle(Theme.c);
			else
				ctx_wrap.fillStyle('yellow'); // Theme.d

			ctx_wrap.fill()
			.stroke();
		};

		this.mouseover = function() {
			isOver = true;
			canvas.style.cursor = 'move'; // pointer move ew-resize
			self.paint(ctx_wrap);
		};

		this.mouseout = function() {
			isOver = false;
			canvas.style.cursor = 'default';
			self.paint(ctx_wrap);
		};

		this.mousedrag = function(e) {
			var t = x_to_time(x + e.dx);
			t = Math.max(0, t);
			// TODO limit moving to neighbours
			frame.time = t;
			dispatcher.fire('time.update', t);
			// console.log('frame', frame);
			// console.log(s, format_friendly_seconds(s), this);
		};

	}

	function repaint() {
		needsRepaint = true;
	}


	function drawLayerContents() {
		renderItems = [];
		// horizontal Layer lines
		for (i = 0, il = layers.length; i <= il; i++) {
			ctx.strokeStyle = Theme.b;
			ctx.beginPath();
			y = i * LINE_HEIGHT;
			y = ~~y - 0.5;

			ctx_wrap
			.moveTo(0, y)
			.lineTo(width, y)
			.stroke();
		}


		var frame, frame2, j;

		// Draw Easing Rects
		for (i = 0; i < il; i++) {
			// check for keyframes
			var layer = layers[i];
			var values = layer.values;

			y = i * LINE_HEIGHT;

			for (j = 0; j < values.length - 1; j++) {
				frame = values[j];
				frame2 = values[j + 1];

				// Draw Tween Rect
				x = time_to_x(frame.time);
				x2 = time_to_x(frame2.time);

				if (!frame.tween || frame.tween == 'none') continue;

				var y1 = y + 2;
				var y2 = y + LINE_HEIGHT - 2;

				renderItems.push(new EasingRect(x, y1, x2, y2, frame, frame2));
			}

			for (j = 0; j < values.length; j++) {
				// Dimonds
				frame = values[j];
				renderItems.push(new Diamond(frame, y));
			}
		}

		// render items
		var item;
		for (i = 0, il = renderItems.length; i < il; i++) {
			item = renderItems[i];
			item.paint(ctx_wrap);
		}
	}

	function setTimeScale() {

		var v = data.get('ui:timeScale').value;
		if (time_scale !== v) {
			time_scale = v;
			time_scaled();
		}
	}

	var over = null;
	var mousedownItem = null;

	function check() {
		var item;
		var last_over = over;
		// over = [];
		over = null;
		for (i = renderItems.length; i-- > 0;) {
			item = renderItems[i];
			item.path(ctx_wrap);

			if (ctx.isPointInPath(pointer.x * dpr, pointer.y * dpr)) {
				// over.push(item);
				over = item;
				break;
			}
		}

		// clear old mousein
		if (last_over && last_over != over) {
			item = last_over;
			if (item.mouseout) item.mouseout();
		}

		if (over) {
			item = over;
			if (item.mouseover) item.mouseover();

			if (mousedown2) {
				mousedownItem = item;
			}
		}



		// console.log(pointer)
	}

	function pointerEvents() {
		if (!pointer) return;

		ctx_wrap
			.save()
			.scale(dpr, dpr)
			.translate(0, MARKER_TRACK_HEIGHT)
			.beginPath()
			.rect(0, 0, Settings.width, SCROLL_HEIGHT)
			.translate(-scrollLeft, -scrollTop)
			.clip()
				.run(check)
			.restore();
	}

	function _paint() {
		if (!needsRepaint) {
			pointerEvents();
			return;
		}

		scroll_canvas.repaint();

		setTimeScale();

		currentTime = data.get('ui:currentTime').value;
		frame_start =  data.get('ui:scrollTime').value;

		/**************************/
		// background

		ctx.fillStyle = Theme.a;
		ctx.clearRect(0, 0, canvas.width, canvas.height);
		ctx.save();
		ctx.scale(dpr, dpr);

		//

		ctx.lineWidth = 1; // .5, 1, 2

		width = Settings.width;
		height = Settings.height;

		var units = time_scale / tickMark1;
		var offsetUnits = (frame_start * time_scale) % units;

		var count = (width - LEFT_GUTTER + offsetUnits) / units;

		// labels only
		for (i = 0; i < count; i++) {
			x = i * units + LEFT_GUTTER - offsetUnits;

			// vertical lines
			ctx.strokeStyle = Theme.b;
			ctx.beginPath();
			ctx.moveTo(x, 0);
			ctx.lineTo(x, height);
			ctx.stroke();

			ctx.fillStyle = Theme.d;
			ctx.textAlign = 'center';

			var t = (i * units - offsetUnits) / time_scale + frame_start;
			t = utils.format_friendly_seconds(t);
			ctx.fillText(t, x, 38);
		}

		units = time_scale / tickMark2;
		count = (width - LEFT_GUTTER + offsetUnits) / units;

		// marker lines - main
		for (i = 0; i < count; i++) {
			ctx.strokeStyle = Theme.c;
			ctx.beginPath();
			x = i * units + LEFT_GUTTER - offsetUnits;
			ctx.moveTo(x, MARKER_TRACK_HEIGHT - 0);
			ctx.lineTo(x, MARKER_TRACK_HEIGHT - 16);
			ctx.stroke();
		}

		var mul = tickMark3 / tickMark2;
		units = time_scale / tickMark3;
		count = (width - LEFT_GUTTER + offsetUnits) / units;

		// small ticks
		for (i = 0; i < count; i++) {
			if (i % mul === 0) continue;
			ctx.strokeStyle = Theme.c;
			ctx.beginPath();
			x = i * units + LEFT_GUTTER - offsetUnits;
			ctx.moveTo(x, MARKER_TRACK_HEIGHT - 0);
			ctx.lineTo(x, MARKER_TRACK_HEIGHT - 10);
			ctx.stroke();
		}

		// Encapsulate a scroll rect for the layers
		ctx_wrap
			.save()
			.translate(0, MARKER_TRACK_HEIGHT)
			.beginPath()
			.rect(0, 0, Settings.width, SCROLL_HEIGHT)
			.translate(-scrollLeft, -scrollTop)
			.clip()
				.run(drawLayerContents)
			.restore();

		// Current Marker / Cursor
		ctx.strokeStyle = 'red'; // Theme.c
		x = (currentTime - frame_start) * time_scale + LEFT_GUTTER;

		var txt = utils.format_friendly_seconds(currentTime);
		var textWidth = ctx.measureText(txt).width;

		var base_line = MARKER_TRACK_HEIGHT - 5, half_rect = textWidth / 2 + 4;

		ctx.beginPath();
		ctx.moveTo(x, base_line);
		ctx.lineTo(x, height);
		ctx.stroke();

		ctx.fillStyle = 'red'; // black
		ctx.textAlign = 'center';
		ctx.beginPath();
		ctx.moveTo(x, base_line + 5);
		ctx.lineTo(x + 5, base_line);
		ctx.lineTo(x + half_rect, base_line);
		ctx.lineTo(x + half_rect, base_line - 14);
		ctx.lineTo(x - half_rect, base_line - 14);
		ctx.lineTo(x - half_rect, base_line);
		ctx.lineTo(x - 5, base_line);
		ctx.closePath();
		ctx.fill();

		ctx.fillStyle = 'white';
		ctx.fillText(txt, x, base_line - 4);

		ctx.restore();

		needsRepaint = false;
		// pointerEvents();

	}

	function y_to_track(y) {
		if (y - MARKER_TRACK_HEIGHT < 0) return -1;
		return (y - MARKER_TRACK_HEIGHT + scrollTop) / LINE_HEIGHT | 0;
	}


	function x_to_time(x) {
		var units = time_scale / tickMark3;

		// return frame_start + (x - LEFT_GUTTER) / time_scale;

		return frame_start + ((x - LEFT_GUTTER) / units | 0) / tickMark3;
	}

	function time_to_x(s) {
		var ds = s - frame_start;
		ds *= time_scale;
		ds += LEFT_GUTTER;

		return ds;
	}

	var me = this;
	this.repaint = repaint;
	this._paint = _paint;

	repaint();

	var mousedown = false, selection = false;

	var dragObject;
	var canvasBounds;

	document.addEventListener('mousemove', onMouseMove);

	canvas.addEventListener('dblclick', function(e) {
		canvasBounds = canvas.getBoundingClientRect();
		var mx = e.clientX - canvasBounds.left , my = e.clientY - canvasBounds.top;


		var track = y_to_track(my);
		var s = x_to_time(mx);


		dispatcher.fire('keyframe', layers[track], currentTime);

	});

	function onMouseMove(e) {
		canvasBounds = canvas.getBoundingClientRect();
		var mx = e.clientX - canvasBounds.left , my = e.clientY - canvasBounds.top;
		onPointerMove(mx, my);
	}

	var pointerdidMoved = false;
	var pointer = null;

	function onPointerMove(x, y) {
		if (mousedownItem) return;
		pointerdidMoved = true;
		pointer = {x: x, y: y};
	}

	canvas.addEventListener('mouseout', function() {
		pointer = null;
	});

	var mousedown2 = false, mouseDownThenMove = false;
	handleDrag(canvas, function down(e) {
			mousedown2 = true;
			pointer = {
				x: e.offsetx,
				y: e.offsety
			};
			pointerEvents();

			if (!mousedownItem) dispatcher.fire('time.update', x_to_time(e.offsetx));
			// Hit criteria
		}, function move(e) {
			mousedown2 = false;
			if (mousedownItem) {
				mouseDownThenMove = true;
				if (mousedownItem.mousedrag) {
					mousedownItem.mousedrag(e);
				}
			} else {
				dispatcher.fire('time.update', x_to_time(e.offsetx));
			}
		}, function up(e) {
			if (mouseDownThenMove) {
				dispatcher.fire('keyframe.move');
			}
			else {
				dispatcher.fire('time.update', x_to_time(e.offsetx));
			}
			mousedown2 = false;
			mousedownItem = null;
			mouseDownThenMove = false;
		}
	);

	this.setState = function(state) {
		layers = state.value;
		repaint();
	};

}

module.exports = TimelinePanel;

},{"./settings":4,"./theme":5,"./ui_canvas":7,"./util_handle_drag":13,"./util_tween":14,"./utils":16,"./view_time_scroller":20}],20:[function(require,module,exports){
var
	Theme = require('./theme'),
	utils = require('./utils'),
	proxy_ctx = utils.proxy_ctx,
	handleDrag = require('./util_handle_drag')
	;


function Rect() {

}

Rect.prototype.set = function(x, y, w, h, color, outline) {
	this.x = x;
	this.y = y;
	this.w = w;
	this.h = h;
	this.color = color;
	this.outline = outline;
};

Rect.prototype.paint = function(ctx) {
	ctx.fillStyle = Theme.b;  // // 'yellow';
	ctx.strokeStyle = Theme.c;

	this.shape(ctx);

	ctx.stroke();
	ctx.fill();
};

Rect.prototype.shape = function(ctx) {
	ctx.beginPath();
	ctx.rect(this.x, this.y, this.w, this.h);
};

Rect.prototype.contains = function(x, y) {
	return x >= this.x && y >= this.y
	 && x <= this.x + this.w && y <= this.y + this.h;
};



function ScrollCanvas(dispatcher, data) {
	var width, height;

	this.setSize = function(w, h) {
		width = w;
		height = h;
	}

	var TOP_SCROLL_TRACK = 20;
	var MARGINS = 15;

	var scroller = {
		left: 0,
		grip_length: 0,
		k: 1
	};

	var scrollRect = new Rect();

	this.paint = function(ctx) {
		var totalTime = data.get('ui:totalTime').value;
		var scrollTime = data.get('ui:scrollTime').value;
		var currentTime = data.get('ui:currentTime').value;

		var pixels_per_second = data.get('ui:timeScale').value;

		ctx.save();

		var w = width - 2 * MARGINS;
		var h = 16; // TOP_SCROLL_TRACK;
		var h2 = h;


		ctx.clearRect(0, 0, width, height);
		ctx.translate(MARGINS, 5);

		// outline scroller
		ctx.beginPath();
		ctx.strokeStyle = Theme.b;
		ctx.rect(0, 0, w, h);
		ctx.stroke();

		var totalTimePixels = totalTime * pixels_per_second;
		var k = w / totalTimePixels;
		scroller.k = k;

		var grip_length = w * k;

		scroller.grip_length = grip_length;

		scroller.left = scrollTime / totalTime * w;

		scrollRect.set(scroller.left, 0, scroller.grip_length, h);
		scrollRect.paint(ctx);

		var r = currentTime / totalTime * w;

		ctx.fillStyle =  Theme.c;
		ctx.lineWidth = 2;

		ctx.beginPath();

		// circle
		// ctx.arc(r, h2 / 2, h2 / 1.5, 0, Math.PI * 2);

		// line
		ctx.rect(r, 0, 2, h + 5);
		ctx.fill()

		ctx.fillText(currentTime && currentTime.toFixed(2), r, h + 14);
		// ctx.fillText(currentTime && currentTime.toFixed(3), 10, 10);
		ctx.fillText(totalTime, 300, 14);

		ctx.restore();
	}

	/** Handles dragging for scroll bar **/

	var draggingx = null;

	this.onDown = function(e) {
		// console.log('ondown', e);

		if (scrollRect.contains(e.offsetx - MARGINS, e.offsety -5)) {
			draggingx = scroller.left;
			return;
		}

		var totalTime = data.get('ui:totalTime').value;
		var pixels_per_second = data.get('ui:timeScale').value;
		var w = width - 2 * MARGINS;

		var t = (e.offsetx - MARGINS) / w * totalTime;
		// t = Math.max(0, t);

		// data.get('ui:currentTime').value = t;
		dispatcher.fire('time.update', t);

	};

	this.onMove = function move(e) {
		if (draggingx != null) {
			var totalTime = data.get('ui:totalTime').value;
			var w = width - 2 * MARGINS;

			dispatcher.fire('update.scrollTime',
				(draggingx + e.dx)  / w * totalTime);

		} else {
			this.onDown(e);
		}

	};

	this.onUp = function(e) {
		draggingx = null;
	}
}

module.exports = ScrollCanvas;
},{"./theme":5,"./util_handle_drag":13,"./utils":16}]},{},[6]);