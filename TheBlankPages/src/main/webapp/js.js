//getPersonCompleteId();
//getPersonComplete();
//createPerson();

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
            document.getElementById("output").innerHTML = text;
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

function createPerson(){
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
            address: {street:street.value, additionalInfo:additionalInfo.value, cityInfo:1}
        })
    };
    
    var promise = fetch(url, conf);
        promise.then(function(response){
            return response.text();
        }).then(function(text){
//            document.getElementById("formAddPerson").style.display='none';//hide form 'add person'
//            reloadData();//refresh table
            document.getElementById("output").innerHTML = text;
        }); 
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