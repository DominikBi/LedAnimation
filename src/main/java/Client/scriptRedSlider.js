
  window.addEventListener("load", function(){
    var slider = document.querySelector("input[type='range']");

    slider.addEventListener("change", function(){
 var valueRed = document.getElementById("sliderRed").value;
    document.querySelector(".range span").innerHTML = valueRed;

    });
    });
