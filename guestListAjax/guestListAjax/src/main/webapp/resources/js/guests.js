$(function() {
    $("#send").click(updateGuests);
});

function updateGuests() {
    var first = $("#first").val();
    var last = $("#last").val();
    
    $.ajax("guest.ajax", {
		"type": "post",
		"data": {
        	"first": first,
                "last": last
		}
    }).done(displayGuests);
}

function displayGuests(data) {
     // var  = "You need to modify this method to display the updated guest list.  Remember to build the entire list before adding it to the DOM.";DOM


    var td1 = $('<td>').text(data.first);
    var td2 = $('<td>').text(data.last);
    var guestList = $('<tr>').append(td0).append(td1).append(td2);
    $("#guestList").append(guestList);


}