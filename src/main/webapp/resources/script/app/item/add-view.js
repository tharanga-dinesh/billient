var ItemAdd = function() {
	
	var initSelect2Component = function() {
		
		$('#itemTax').select2({
			allowClear: true
		});
		
		$('#itemCategory').select2({
			allowClear: true,
		});
		
	};
	
	return {
		init: function() {
			initSelect2Component();
		}
	};
	
}();