 var myVideoStream = document.getElementById('myVideo')     
  var myStoredInterval = 0
 var myImage = document.getElementById('myCanvas')
  
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
	  
	  var loadDiv = document.createElement('div');
	  loadDiv.id = 'load';
	  loadDiv.innerHTML = '<img src="./assets/img/loading.gif" alt="loading">';
	  document.body.appendChild(loadDiv);
	  // 이미지 데이터를 추출하여 전송 192.168.80.26
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
		    
		    setTimeout(function(){
		    	document.body.removeChild(loadDiv);
		    	window.location.href="/result";
		    },5000);
	  })
	  .catch(function(error) {
	    console.error('실패', error);
	  });

}

 function upload(){
	 const canvas = document.getElementById('myCanvas');
	 const ctx = canvas.getContext('2d');
	 const imageInput = document.getElementById('imageinput');	 
	 imageInput.addEventListener('change', function(e) {
		  const file = e.target.files[0];
		  const reader = new FileReader();

		  reader.onload = function(e) {
		    const img = new Image();
		    img.onload = function() {
		      canvas.width = img.width;
		      canvas.height = img.height;
		      ctx.drawImage(img, 0, 0);
		    }
		    img.src = e.target.result;
		  }
		  reader.readAsDataURL(file);
		});	 
	 
 }
 
 function send(){
	  var myCanvasElement = document.getElementById('myCanvas');	  
	  var imageData = myCanvasElement.toDataURL('image/png');
	  var loadDiv = document.createElement('div');
	  loadDiv.id = 'load';
	  loadDiv.innerHTML = '<img src="./assets/img/loading.gif" alt="loading">';
	  document.body.appendChild(loadDiv);
	  
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
		    
		    setTimeout(function(){
		    	document.body.removeChild(loadDiv);
		    	window.location.href="/result";
		    },5000);
		  })
		  .catch(function(error) {
		    console.error('실패', error);
		  });
 }
 
 function upload2(){
	 const canvas = document.getElementById('myCanvas');
	 const ctx = canvas.getContext('2d');
	 const imageInput = document.getElementById('imageinput');	 
	 imageInput.addEventListener('change', function(e) {
		  const file = e.target.files[0];
		  const reader = new FileReader();

		  reader.onload = function(e) {
		    const img = new Image();
		    img.onload = function() {
		      canvas.width = img.width;
		      canvas.height = img.height;
		      ctx.drawImage(img, 0, 0);
		    }
		    img.src = e.target.result;
		  }
		  reader.readAsDataURL(file);
		});	 
	 
 }
 
 function send2(){
	  var myCanvasElement = document.getElementById('myCanvas');	  
	  var imageData = myCanvasElement.toDataURL('image/png');
	  var loadDiv = document.createElement('div');
	  loadDiv.id = 'load';
	  loadDiv.innerHTML = '<img src="./assets/img/loading.gif" alt="loading">';
	  document.body.appendChild(loadDiv);	  
	  fetch('http://localhost:5000/lip', {
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
		    
		    setTimeout(function(){
		    	document.body.removeChild(loadDiv);
		    	window.location.href="/result2";
		    },5000);
		  })
		  .catch(function(error) {
		    console.error('실패', error);
		  });
 }
 
