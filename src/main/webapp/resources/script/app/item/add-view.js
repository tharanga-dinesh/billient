var ItemAdd = function() {
	
	var initButtons = function() {
		initButtonAddNewCategory();
	};
	
	var initButtonAddNewCategory = function() {
		$("#btn_add_new_category").on("click", function() {
			alert();
		});
	};
	
	var initSelect2Component = function() {
		
		$('#itemTax').select2({
			allowClear: true,
			container: "#taxContainer"
		});
		
		$('#itemCategory').select2({
			allowClear: true,
			container: "#categoryContainer"
		});
		
	};
	
	var initValidator = function() {
       var form = $('#frm_item');
       var errorHandler = $('.errorHandler', form);
       var successHandler = $('.successHandler', form);
       form.validate({
    	   errorElement: "span", // contain the error msg in a span tag
           errorClass: 'help-block',
           errorPlacement: function (error, element) { // render error placement for each input type
               if (element.attr("type") == "radio" || element.attr("type") == "checkbox" ) { // for chosen elements, need to insert the error after the chosen container
                   error.insertAfter($(element).closest('.form-group').children('div').children().last());
               } else if (element.attr("name") == "dd" || element.attr("name") == "mm" || element.attr("name") == "yyyy" || element.closest('.input-group').has('.input-group-prepend').length || element.closest('.form-group').has('.input-group-append').length) {
                   error.insertAfter($(element).closest('.form-group').children('div'));
               } else if (element.closest('.form-group').has('.select2').length ){
               	error.insertAfter($(element).closest('.form-group').children('span'));
               } else {
                   error.insertAfter(element); 
               }
           },
           ignore: "",
			rules: {
				itemName: {
					required: true,  
				},
				itemCategory: {
					required: true,  
				},
			},
			messages: {
				itemName: "Please specify your name", 
			}, 
            invalidHandler: function (event, validator) { //display error alert on form submit
                successHandler.hide();
                errorHandler.show();
            },
            highlight: function (element) {
                $(element).closest('.help-block').removeClass('is-invalid');
                // display OK icon
                $(element).removeClass('is-valid').addClass('is-invalid').closest('.form-group').removeClass('has-success').addClass('has-danger');
                // add the Bootstrap error class to the control group
            },
            unhighlight: function (element) { // revert the change done by hightlight
                $(element).closest('.form-group').removeClass('has-danger');
                // set error class to the control group
            },
            success: function (label, element) {
                label.addClass('help-block is-valid');
                // mark the current input as valid and display OK icon
                $(element).removeClass('is-invalid').addClass('is-valid').closest('.form-group').removeClass('has-danger').addClass('has-success');
            },
            submitHandler: function (form) {
                successHandler.show();
                errorHandler.hide();
                return true;
            }
		});
	};
	
	return {
		init: function() {
			console.log("init");
			initSelect2Component();
			initButtons();
			initValidator();
		}
	};
	
}();