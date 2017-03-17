var fname = document.getElementById("fname");
var lname = document.getElementById("lname");
var email = document.getElementById("email");
var phone = document.getElementById("phone");
var phoneDesc = document.getElementById("phoneDesc");
var street = document.getElementById("street");
var additionalInfo = document.getElementById("additionalInfo");
var zipCode = document.getElementById("zipCode");
var city = document.getElementById("city");
var idOfRecordToUpdate = 0;
var idOfRecordToDelete = 0;
//getPersonCompleteId();
//getPersonComplete();
//createPerson();
var btnAddPerson = document.getElementById("addPerson");
var btnFindPerson = document.getElementById("findPerson");
var btnGetAllPersons = document.getElementById("getAllPersons");


btnGetAllPersons.addEventListener("click",getPersonComplete);
btnAddPerson.addEventListener("click",showFormAddPerson);
btnFindPerson.addEventListener("click",showFormFindPerson);

function getPersonCompleteId(id){
    var url = "http://localhost:8084/TheBlankPages/api/person/complete/"+id;
    var conf = {method: 'get'};
    var promise = fetch(url, conf);
        promise.then(function(response){
            return response.text();
        }).then(function(text){
            if(data.quote!==null){
                document.getElementById("output").innerHTML = text;
            }
            if(data.quote!=null){
                alert("abc");
            }
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
            var lon = "<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Address Line 1</th><th>Address Line 2</th><th>Zip Code</th><th>City</th><th>Phone Number(s)</th><th>Email</th><th>Options</th>";
            for (var x in persons) {
                lon += "<tr><td>"+persons[x].id+"</td><td>"+persons[x].firstName+"</td><td>"+persons[x].lastName+"</td><td>"+persons[x].address.street+"</td><td>"+persons[x].address.additionalInfo+"</td><td>"+persons[x].address.cityInfo.zipCode+"</td><td>"+persons[x].address.cityInfo.city+"</td><td>"+getPhones(persons[x].phones)+"</td><td>"+persons[x].email+"</td><td><button id=\"delete#"+persons[x].id+"\" onclick=\"deletePerson(this.id)\">delete</button><button id=\"update#"+persons[x].id+"\" onclick=\"showFormUpdatePerson(this.id)\">update</button></td></tr>";
            }
            document.getElementById("outputTable").innerHTML = lon;
            document.getElementById("formPerson").reset();
            document.getElementById("formPerson").style.display='none';
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

function showFormAddPerson(){
    document.getElementById("formPerson").style.display='block';
    document.getElementById("toggle").value = "Add";
    document.getElementById("toggletext").innerHTML  = document.getElementById("toggle").value+" person";
    document.getElementById("formPerson").reset();
    document.getElementById("lname").style.display='block';
    document.getElementById("email").style.display='block';
    document.getElementById("phone").style.display='block';
    document.getElementById("phoneDesc").style.display='block';
    document.getElementById("street").style.display='block';
    document.getElementById("additionalInfo").style.display='block';
    document.getElementById("zipCode").style.display='block';
    document.getElementById("city").style.display='block';
}

function showFormFindPerson(){
    document.getElementById("formPerson").style.display='block';
    document.getElementById("toggle").value = "Find";
    document.getElementById("toggletext").innerHTML  = document.getElementById("toggle").value+" person";
    document.getElementById("formPerson").reset();
//    var formInputFields = document.querySelectorAll("#formPerson input[type=text]");
//    for (var x in formInputFields){
//        formInputFields[x].style.visibility="hidden";
//    }
//    document.getElementById("fname").style.visibility ="visible";
//    document.getElementById("fname").style.visibility ="hidden";
    document.getElementById("lname").style.display='none';
    document.getElementById("email").style.display='none';
    document.getElementById("phone").style.display='none';
    document.getElementById("phoneDesc").style.display='none';
    document.getElementById("street").style.display='none';
    document.getElementById("additionalInfo").style.display='none';
    document.getElementById("zipCode").style.display='none';
    document.getElementById("city").style.display='none';
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
            document.getElementById("fname").style.display='block';
            document.getElementById("lname").style.display='block';
            document.getElementById("email").style.display='block';
            document.getElementById("phone").style.display='block';
            document.getElementById("phoneDesc").style.display='block';
            document.getElementById("street").style.display='block';
            document.getElementById("additionalInfo").style.display='block';
            document.getElementById("zipCode").style.display='block';
            document.getElementById("city").style.display='block';
    });
}

function formAction() {
    var wordToCheck = document.getElementById("toggle").value;
    if(wordToCheck==="Add"){
        addPerson();
    }
    else if(wordToCheck==="Update"){
        updatePerson();
    }
    else if(wordToCheck==="Find"){
        findPerson();
    }
}
function findPerson() {
    var inputtedFirstName = document.getElementById("fname").value;
    var url = "http://localhost:8084/TheBlankPages/api/person/complete/by/firstname/"+inputtedFirstName;
    var conf = {method: 'get'};
    var promise = fetch(url, conf);
        promise.then(function(response){
            return response.text();
        }).then(function(text){
            var persons = JSON.parse(text);
            var lon = "<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Address Line 1</th><th>Address Line 2</th><th>Zip Code</th><th>City</th><th>Phone Number(s)</th><th>Email</th><th>Options</th>";
            for (var x in persons) {
                lon += "<tr><td>"+persons[x].id+"</td><td>"+persons[x].firstName+"</td><td>"+persons[x].lastName+"</td><td>"+persons[x].address.street+"</td><td>"+persons[x].address.additionalInfo+"</td><td>"+persons[x].address.cityInfo.zipCode+"</td><td>"+persons[x].address.cityInfo.city+"</td><td>"+getPhones(persons[x].phones)+"</td><td>"+persons[x].email+"</td><td><button id=\"delete#"+persons[x].id+"\" onclick=\"deletePerson(this.id)\">delete</button><button id=\"update#"+persons[x].id+"\" onclick=\"showFormUpdatePerson(this.id)\">update</button></td></tr>";
            }
            document.getElementById("outputTable").innerHTML = lon;
            document.getElementById("formPerson").reset();
            //alert(person);
//    document.getElementsByTagName("input").hide();
    
//    var elem = document.getElementById('frmMain').elements;
//        for(var i = 0; i < elem.length; i++)
//        {
    });    
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
            document.getElementById("formPerson").reset();
            document.getElementById("formPerson").style.display='none';
            alert("Person added: "+text);
        });
}  

function updateInputVars(){
    fname = document.getElementById("fname");
    lname = document.getElementById("lname");
    email = document.getElementById("email");
    phone = document.getElementById("phone");
    phoneDesc = document.getElementById("phoneDesc");
    street = document.getElementById("street");
    additionalInfo = document.getElementById("additionalInfo");
    zipCode = document.getElementById("zipCode");
    city = document.getElementById("city");
}

function updatePerson(id){
    updateInputVars();
    var url = "http://localhost:8084/TheBlankPages/api/person/update";
    var conf = {
        method: 'post',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        },
        body: JSON.stringify({
//            id: idOfRecordToUpdate,
            id: 5,
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