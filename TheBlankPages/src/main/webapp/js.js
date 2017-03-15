//var getRandomPerson = document.getElementById("btnGetRandomPerson");
//
//getRandomPerson.addEventListener("click",getRandomPersonFunction);
getPersonsById();

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

function getPersonsById(){
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