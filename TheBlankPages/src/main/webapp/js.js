//getPersonCompleteId();
getPersonComplete();
//createPerson();
var btnUpdatePerson = document.getElementById("updatePerson");
var btnAddPerson = document.getElementById("addPerson");

btnUpdatePerson.addEventListener("click",showFormUpdatePerson);
btnAddPerson.addEventListener("click",showFormAddPerson);

function getPersonCompleteId(){
    var url = "http://localhost:8084/TheBlankPages/api/person/complete/1";
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
            //document.getElementById("output").innerHTML = text;
            
            var persons = JSON.parse(text);
        var lon = "<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Options</th>";
            for (var x in persons) {
                lon += "<tr><td>"+persons[x].id+"</td><td>"+persons[x].firstName+"</td><td>"+persons[x].lastName+"</td><td>"+persons[x].email+"</td><td><button id=\"delete#"+persons[x].id+"\" onclick=\"deletePerson(this.id)\">delete</button><button id=\"update#"+persons[x].id+"\" onclick=\"updatePerson(this.id)\">update</button></td></tr>";
            }
            document.getElementById("outputTable").innerHTML = lon;
        });
}


function deletePerson(id){
    var idOfRecordToDelete = ""+id.split("#")[1];//the id parameter consists of 'delete#' and an object id, of which only the latter is desired kept 
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

function showFormUpdatePerson(){
    document.getElementById("formPerson").style.display='block';
    document.getElementById("toggle").value = "Update";
    document.getElementById("toggletext").innerHTML = document.getElementById("toggle").value+" person";;
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
//    var url = "http://localhost:8084/TheBlankPages/api/person";
//    var conf = {
//        method: 'post',
//        headers: {
//        'Accept': 'application/json',
//        'Content-Type': 'application/json'
//        },
//        body: JSON.stringify({
//            firstName: fname.value,
//            lastName: lname.value,
//            email: email.value,
//            phones: [{number:phone.value,description:phoneDesc.value}],
//            address: {street:street.value, additionalInfo:additionalInfo.value, cityInfo:{zipCode: zipCode.value}}
//        })
//    };
//    
//    var promise = fetch(url, conf);
//        promise.then(function(response){
//            return response.text();
//        }).then(function(text){
//            document.getElementById("output").innerHTML = text;
//        });
document.getElementById("formPerson").style.display='none';
alert("add");
}  

function updatePerson(id){
//    var url = "http://localhost:8084/TheBlankPages/api/person";
//    var conf = {
//        method: 'put',
//        headers: {
//        'Accept': 'application/json',
//        'Content-Type': 'application/json'
//        },
//        body: JSON.stringify({
//            firstName: fname.value,
//            lastName: lname.value,
//            email: email.value,
//            phones: [{number:phone.value,description:phoneDesc.value}],
//            address: {street:street.value, additionalInfo:additionalInfo.value, cityInfo:{zipCode: zipCode.value}}
//        })
//    };
//    
//    var promise = fetch(url, conf);
//        promise.then(function(response){
//            return response.text();
//        }).then(function(text){
//            document.getElementById("output").innerHTML = text;
//        }); 
//        
        document.getElementById("formPerson").style.display='none';
alert(id);
}  


































function getPersonByIdTable(){
    var url = "http://localhost:8084/TheBlankPages/api/person/byid/1";
    var conf = {method: 'get'};
    var promise = fetch(url, conf);
        promise.then(function(response){
            return response.text();
        }).then(function(text){
            
        
//        var lon = "<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Phone</th><th>Options</th>";
//            for (var x in persons) {
//                lon += "<tr><td>"+persons[x].id+"</td><td>"+persons[x].fName+"</td><td>"+persons[x].lName+"</td><td>"+persons[x].phone+"</td><td><button id=\"delete#"+persons[x].id+"\" onclick=\"deletePerson(this.id)\">delete</button></td></tr>";
//            }
//            document.getElementById("outputTable").innerHTML = lon;
        
        document.getElementById("output").innerHTML = text;
//        var persons = JSON.parse(text);
//        document.getElementById("output").innerHTML = persons;
        });
}


//var getRandomPerson = document.getElementById("btnGetRandomPerson");
//
//getRandomPerson.addEventListener("click",getRandomPersonFunction);

function getPersons(){
    var url = "http://localhost:8084/TheBlankPages/api/person/all";
    var conf = {method: 'get'};
    var promise = fetch(url, conf);
        promise.then(function(response){
            return response.text();
        }).then(function(text){
            
        var persons = JSON.parse(text);
//        var lon = "<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Phone</th><th>Options</th>";
//            for (var x in persons) {
//                lon += "<tr><td>"+persons[x].id+"</td><td>"+persons[x].fName+"</td><td>"+persons[x].lName+"</td><td>"+persons[x].phone+"</td><td><button id=\"delete#"+persons[x].id+"\" onclick=\"deletePerson(this.id)\">delete</button></td></tr>";
//            }
//            document.getElementById("outputTable").innerHTML = lon;
        document.getElementById("output").innerHTML = persons;
        });
}