$(document).ready(function(){
	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();

	// Select/Deselect checkboxes
	var checkbox = $('table tbody input[type="checkbox"]');
	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;
			});
		} else{
			checkbox.each(function(){
				this.checked = false;
			});
		}
	});
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});

	$('.edit').on('click', onEdit);
	$('.delete').on('click', onDelete);

	function onEdit(e){
	    e.preventDefault();
	    var id = $(this).data('id');
	    $('#editEmployeeModal').find('input[name=id]').val(id);
	    var name = $(this).data('name');
	    $('#editEmployeeModal').find('input[name=name]').val(name);
	    var lastname = $(this).data('lastname');
	    $('#editEmployeeModal').find('input[name=lastname]').val(lastname);
	    var phone = $(this).data('phone');
	    $('#editEmployeeModal').find('input[name=phone]').val(phone);
	}

	function onDelete(e){
	    e.preventDefault();
	    var id = $(this).data('id');
	    console.log(id);
        $('#deleteEmployeeModal').find('input[name=clientId]').val(id);
	}
});