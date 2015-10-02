$('document').ready(function () {
    updateTable();
});

$('#refresh').on('click', function () {
    updateTable();
});

$("#create").on('click', function () {
    var person;
    $.ajax({
        method: "POST",
        url: "http://localhost:8080/Jax-RS-Ex2/api/person",
        datatype: "json",
        processData: false,
        contentType: 'application/json',
        data: JSON.stringify({firstName: $('#firstname').val(), lastName: $('#lastname').val(), phone: $('#phone').val()})}).updateTable()
});

$('body').on('click', '.removebtn', function () {
    if (confirm("Are you sure you want to delete this Person")) {
        var id = $(this).attr("personid");
        var tr = $(this).closest('tr');
        tr.remove();
        $.ajax({
            method: "DELETE",
            url: "http://localhost:8080/Jax-RS-Ex2/api/person/" + id
        });
    }
});

var id;
var firstname;
var lastname;
var phone;
$('body').on('click', '.editbtn', function () {
    id = $(this).attr("personid");
    var tr = $(this).closest("tr");
    firstname = tr.children().eq(0);
    lastname = tr.children().eq(1);
    phone = tr.children().eq(2);
    $('#selectedId').val(id);
    $('#selectedFirstname').val(firstname.text());
    $('#selectedLastname').val(lastname.text());
    $('#selectedPhone').val(phone.text());
});

$("#update").on('click', function () {
    var editedfirstname = $('#selectedFirstname').val();
    var editedLastname = $('#selectedLastname').val();
    var editedphone = $('#selectedPhone').val();
    updatePerson(id, editedfirstname, editedLastname, editedphone);
    firstname.text(editedfirstname);
    lastname.text(editedLastname);
    phone.text(editedphone);
});


function updatePerson(id, firstname,lastname,phone) {
    $.ajax({
        method: "PUT",
        url: "http://localhost:8080/Jax-RS-Ex2/api/person",
        datatype: "json",
        processData: false,
        contentType: 'application/json',
        data: JSON.stringify({id: id, firstName: firstname, lastName: lastname, phone: phone})}).done();
}


function updateTable() {
    $.ajax({
        method: "GET",
        url: "http://localhost:8080/Jax-RS-Ex2/api/person",
        success: function (data) {
            fillTableWithPersons(data);
        }
    });
}

function fillTableWithPersons(data) {
    $("#tableBody > tr").remove();
    data.forEach(function (person) {
        $('#tableBody').append("<tr><td>" + person.firstName + "</td>" +
                "<td>" + person.lastName + "</td>" +
                "<td>" + person.phone + "</td>" +
                "<td><a id='editPerson' data-toggle='collapse' class= 'editbtn btn btn-info btn-sm' personid=" + person.id +" data-parent='#accordion' href='#collapseTwo'>EDIT</a></td>" +
                "<td><button class='removebtn btn btn-warning btn-sm' personid=" + person.id + ">REMOVE</button></td>" +
                "</tr>");
    });
}
;