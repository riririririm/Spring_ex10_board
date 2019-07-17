/**
 * 
 */

/////////summer note///////////
		
		$("#submitBtn").click(function() {
			//다른 input들 검증
			if($("#contents").summernote("isEmpty")){
				alert("Empty");
			}else{
				$("#frm").submit();
			}
		});
		
		$("#summernote2").summernote({
			toolbar:[]
		});
		$('#contents').summernote({
			callbacks:{
				onImageUpload: function(files){
					var formData = new FormData();
					formData.append('file',files[0]);
					$.ajax({
						type:"POST",
						url:"../ajax/summerFileUpload",
						data:formData,
						enctype:"multipart/form-data",
						cache:false,
						contentType:false,
						processData:false,
						success:function(data){
							data=data.trim();
							$("#contents").summernote('editor.insertImage', data);
						}
					});
				},//end of onImageUpload
				
				onMediaDelete :function(files){
					var fileName = $(files[0]).attr('src');
					$.ajax({
						type:"POST",
						url:"../ajax/summerFileDelete",
						data:{fileName:fileName},
						success:function(data){
							console.log(data);
						}
					});
				}//end of OnMediaDelete
			}
		});
		