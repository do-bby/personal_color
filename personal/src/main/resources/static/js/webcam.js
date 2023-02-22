 var myVideoStream = document.getElementById('myVideo')     
  var myStoredInterval = 0
  
function getVideo(){
  navigator.getMedia = navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia || navigator.msGetUserMedia;
  navigator.getMedia({video: true, audio: false},
                     
    function(stream) {
      myVideoStream.srcObject = stream   
      myVideoStream.play();
  }, 
                     
   function(error) {
     alert('webcam not working');
  });
}
  
 function takeSnapshot() {
	  var myCanvasElement = document.getElementById('myCanvas');
	  var myCTX = myCanvasElement.getContext('2d');
	  myCTX.drawImage(myVideoStream, 0, 0, myCanvasElement.width, myCanvasElement.height);
	  
	  // 이미지 데이터를 추출하여 전송
	  var imageData = myCanvasElement.toDataURL('image/png');
	  fetch('http://localhost:5000/image', {
	    method: 'POST',
	    headers: {
	      'Content-Type': 'application/json'
	    },
	    body: JSON.stringify({
	      image: imageData
	    })
	  })
	  .then(function(response) {
	    console.log('성공');
	    console.log(imageData);
	  })
	  .catch(function(error) {
	    console.error('실패', error);
	  });

}
