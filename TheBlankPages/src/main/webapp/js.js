var idOfRecordToUpdate = 0;
var idOfRecordToDelete = 0;
//getPersonCompleteId();
getPersonComplete();
//createPerson();
var btnUpdatePerson = document.getElementById("updatePerson");
var btnAddPerson = document.getElementById("addPerson");

btnUpdatePerson.addEventListener("click",showFormUpdatePerson);
btnAddPerson.addEventListener("click",showFormAddPerson);

function getPersonCompleteId(id){
    var url = "http://localhost:8084/TheBlankPages/api/person/complete/"+id;
    var conf = {method: 'get'};
    var promise = fetch(url, conf);
        promise.then(function(response){
            return response.text();
        }).then(function(text){
            document.getElementById("output").innerHTML = text;
        });
}

function getPersonComplete(){
    var url = "http://localhost:8084/TheBlankPages/api/person/complete";
    var conf = {method: 'get'};
    var promise = fetch(url, conf);
        promise.then(function(response){
            return response.text();
        }).then(function(text){
            var persons = JSON.parse(text);
            var lon = "<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Phone number(s)</th><th>Email</th><th>Options</th>";
            for (var x in persons) {
                lon += "<tr><td>"+persons[x].id+"</td><td>"+persons[x].firstName+"</td><td>"+persons[x].lastName+"</td><td>"+getPhones(persons[x].phones)+"</td><td>"+persons[x].email+"</td><td><button id=\"delete#"+persons[x].id+"\" onclick=\"deletePerson(this.id)\">delete</button><button id=\"update#"+persons[x].id+"\" onclick=\"showFormUpdatePerson(this.id)\">update</button></td></tr>";
            }
            document.getElementById("outputTable").innerHTML = lon;
        });
}


function getPhones(phoneNumbers){
    var tempString = "";
    for(var x in phoneNumbers){
        tempString += phoneNumbers[x].number+"\n"; 
    }
    return tempString;
}

function deletePerson(id){
    idOfRecordToDelete = ""+id.split("#")[1];//the id parameter consists of 'delete#' and an object id, of which only the latter is desired kept 
    var url = "http://localhost:8084/TheBlankPages/api/person/delete/"+idOfRecordToDelete;
    var conf = {method: 'DELETE',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        }
    };
    var promise = fetch(url, conf);
        promise.then(function(response){
            return response.text();
        }).then(function(text){
            getPersonComplete();
            alert("Person deleted: "+text);
        });
}

var fname = document.getElementById("fname");
var lname = document.getElementById("lname");
var email = document.getElementById("email");
var phone = document.getElementById("phone");
var phoneDesc = document.getElementById("phoneDesc");
var street = document.getElementById("street");
var additionalInfo = document.getElementById("additionalInfo");
var zipCode = document.getElementById("zipCode");
var city = document.getElementById("city");

function showFormAddPerson(){
    document.getElementById("formPerson").style.display='block';
    document.getElementById("toggle").value = "Add";
    document.getElementById("toggletext").innerHTML  = document.getElementById("toggle").value+" person";
}

function showFormUpdatePerson(id){
    document.getElementById("formPerson").style.display='block';
    document.getElementById("toggle").value = "Update";
    document.getElementById("toggletext").innerHTML = document.getElementById("toggle").value+" person";
    idOfRecordToUpdate = ""+id.split("#")[1];//the id parameter consists of 'update#' and an object id, of which only the latter is desired kept 
    var url = "http://localhost:8084/TheBlankPages/api/person/complete/"+idOfRecordToUpdate;
    var conf = {method: 'get'};
    var promise = fetch(url, conf);
        promise.then(function(response){
            return response.text();
        }).then(function(text){
            var person = JSON.parse(text);
            document.getElementById("fname").value = person.firstName;
            document.getElementById("lname").value = person.lastName;
            document.getElementById("email").value = person.email;
            document.getElementById("phone").value = person.phones[0].number;
            document.getElementById("phoneDesc").value = person.phones[0].description;
            document.getElementById("street").value = person.address.street;
            document.getElementById("additionalInfo").value = person.address.additionalInfo;
            document.getElementById("zipCode").value = person.address.cityInfo.zipCode;
            document.getElementById("city").value = person.address.cityInfo.city;
    });
}

function addOrUpdate() {
    var wordToCheck = document.getElementById("toggle").value;
    if(wordToCheck==="Add"){
        addPerson();
    }
    else if(wordToCheck==="Update"){
        updatePerson();
    }
}

function addPerson(){
    var url = "http://localhost:8084/TheBlankPages/api/person";
    var conf = {
        method: 'post',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            firstName: fname.value,
            lastName: lname.value,
            email: email.value,
            phones: [{number:phone.value,description:phoneDesc.value}],
            address: {street:street.value, additionalInfo:additionalInfo.value, cityInfo:{zipCode: zipCode.value}}
        })
    };
    
    var promise = fetch(url, conf);
        promise.then(function(response){
            return response.text();
        }).then(function(text){
            document.getElementById("output").innerHTML = text;
        });
//document.getElementById("formPerson").style.display='none';
//alert("add");
}  

function updatePerson(id){
    var url = "http://localhost:8084/TheBlankPages/api/person/update";
    var conf = {
        method: 'post',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: idOfRecordToUpdate,
            firstName: fname.value,
            lastName: lname.value,
            email: email.value,
            phones: [{number:phone.value,description:phoneDesc.value}],
            address: {street:street.value, additionalInfo:additionalInfo.value, cityInfo:{zipCode: zipCode.value}}
        })
    };
    var promise = fetch(url, conf);
        promise.then(function(response){
            return response.text();
        }).then(function(text){
            getPersonComplete();
            alert("Person updated: "+text);
            document.getElementById("formPerson").style.display='none';
        }); 
}