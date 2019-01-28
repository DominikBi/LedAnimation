
  window.addEventListener("load", function(){
    var sliders = document.querySelector("input[type='range']");

for(var index = 0; index < sliders.length; index++){
    slider = sliders[index];
    alert("asd")
slider.addEventListener("change", function(){
    var value = slider.value;
    Console.info(value);
    document.querySelector(".range span").innerHTML = value;
    });
}
 });
