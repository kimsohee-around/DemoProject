/**
 * 
 */
function quilljsediterInit(){
    var option = {
        modules: {
            toolbar: [
                [{header: [1,2,false] }],
                ['bold', 'italic', 'underline'],
                ['image', 'code-block'],
                [{ list: 'ordered' }, { list: 'bullet' }]
            ]
        },
        placeholder: '자세한 내용을 입력해 주세요!',
        theme: 'snow'
    };

    quill = new Quill('#editor', option);
 //   quill.on('text-change', function() {
 //       document.getElementById("quill_html").value = quill.root.innerHTML;
//});
 	
    quill.on('text-change', function(delta, oldDelta, source) {
             // 에디터 내용이 변경될 때의 로직
             document.getElementById("quill_html").value = quill.root.innerHTML;
             console.log('Text changed:', delta);
             

           // 이미지 삭제 시의 로직
             var currrentContents = quill.getContents();
             var diff = currrentContents.diff(oldDelta);
             try {
              // console.log(diff.ops[0]);
              // console.log(diff.ops[1]);
              console.log(diff.ops)
              diff.ops.forEach(op => {
            	  console.log('op',op)
            	  if(op.insert && op.insert.image !== null) {
			        console.log('Image deleted:', op);
            	  }	  
              })
             } catch (_error) {}
         });

}

/* 
quill.on("text-change", (delta, oldDelta, source) => {
  if (source === "user") {
    let currrentContents = quill.getContents();
    let diff = currrentContents.diff(oldDelta);
    try {
      console.log(diff.ops[0].insert.image);
    } catch (_error) {}
  }
});
*
*/

quilljsediterInit();

function selectLocalImage() {
    const fileInput = document.createElement('input');
    fileInput.setAttribute('type', 'file');
    console.log("input.type " + fileInput.type);

    fileInput.click();

    fileInput.addEventListener("change", function () {  // change 이벤트로 input 값이 바뀌면 실행
        const formData = new FormData();
        const file = fileInput.files[0];
        formData.append('uploadFile', file);

        $.ajax({
            type: 'post',
            enctype: 'multipart/form-data',
            url: './upload',
            data: formData,
            processData: false,
            contentType: false,
            dataType: 'json',
            success: function (data) {
            	console.log('res',data)
                const range = quill.getSelection(); // 사용자가 선택한 에디터 범위
                // uploadPath에 역슬래시(\) 때문에 경로가 제대로 인식되지 않는 것을 슬래시(/)로 변환
                //data.uploadPath = data.uploadPath.replace(/\\/g, '/');

                quill.insertEmbed(range.index, 'image', "/upload/" + data.filename);  // +"/"+ data.uuid +"_"+
				console.log(document.querySelector('#editor').innerHTML)
				console.log(quill.root.innerHTML)
            },
            error: function (err) {
                console.log(err);
            }
        });

    });
}
quill.getModule('toolbar').addHandler('image', function () {
    selectLocalImage();
});
