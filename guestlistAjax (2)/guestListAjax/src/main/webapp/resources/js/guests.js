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

    console.log(data);
    let list=$("<ol>");
    for(let g of data){
       let item=$("<li>") .text(g.first+" "+g.last); //
       list.append(item);
    }
    var guestList = "You need to modify this method to display the updated guest list.  Remember to build the entire list before adding it to the DOM.";
    $("#guestList").html(list); // adds the list to the div element in the guest.jsp file
   $("#first").val("");
    $("#last").val("");
    
}