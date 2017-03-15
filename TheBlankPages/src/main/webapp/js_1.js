var getRandomPerson = document.getElementById("btnGetRandomPerson");

getRandomPerson.addEventListener("click",getRandomPersonFunction);

function getRandomPersonFunction(evt){
    evt.preventDefault();
    var url = "http://localhost:8084/62Rest/api/person/random";
    var conf = {method: 'get'};
    var promise = fetch(url, conf);
        promise.then(function(response){
            return response.text();
        }).then(function(text){
            document.getElementById("outputTable").innerHTML = text;
        });
}


var inputGetSpecifiedPerson = document.getElementById("inputGetSpecifiedPerson");


//var getSpecifiedPerson = document.getElementById("btnGetSpecifiedPerson");

//getSpecifiedPerson.addEventListener("click",getSpecifiedPersonFunction);

function getSpecifiedPerson(){
    var url = "http://localhost:8084/62Rest/api/person/"+inputGetSpecifiedPerson.value;
    var conf = {method: 'get'};
    var promise = fetch(url, conf);
        promise.then(function(response){
            return response.text();
        }).then(function(text){
            document.getElementById("output").innerHTML = text;
        });
}












function createFunctions(evt){
    //alert("hello");
    var url = "http://localhost:8084/61Rest/api/quote";
    var conf = {method: 'post'};
    var promise = fetch(url, conf);
        promise.then(function(response){
            return response.text();
        }).then(function(text){
            document.getElementById("outputTable").innerHTML = text;
        }); 
}


document.getElementById("btnReloadData").addEventListener("click",reloadData);//add event listener to button

reloadData();

function reloadData(){
    var url = "http://localhost:8084/62Rest/api/person/all";
    var conf = {method: 'get'};
    var promise = fetch(url, conf);
        promise.then(function(response){
            return response.text();
        }).then(function(text){
            
        var persons = JSON.parse(text);
        var lon = "<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Phone</th><th>Options</th>";
            for (var x in persons) {
                lon += "<tr><td>"+persons[x].id+"</td><td>"+persons[x].fName+"</td><td>"+persons[x].lName+"</td><td>"+persons[x].phone+"</td><td><button id=\"delete#"+persons[x].id+"\" onclick=\"deletePerson(this.id)\">delete</button></td></tr>";
            }
            document.getElementById("outputTable").innerHTML = lon;
        });
    
}  

function deletePerson(id){
    var idOfRecordToDelete = ""+id.split("#")[1];//the id parameter consists of 'delete#' and an object id, of which only the latter is desired kept 
    var url = "http://localhost:8084/62Rest/api/person/delete/"+idOfRecordToDelete;
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
            reloadData();
            alert("Person deleted: "+text);
        });
}


var fname = document.getElementById("fname");
var lname = document.getElementById("lname");
var phone = document.getElementById("phone");

function addNewPerson(){
    var url = "http://localhost:8084/62Rest/api/person/add";
    var conf = {
        method: 'post',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: 5,
            fName: fname.value,
            lName: lname.value,
            phone: phone.value 
        })
    };
    
    var promise = fetch(url, conf);
        promise.then(function(response){
            return response.text();
        }).then(function(text){
            document.getElementById("formAddPerson").style.display='none';//hide form 'add person'
            reloadData();//refresh table
            alert("Person added: "+text);//give feedback
        }); 
    }  

document.getElementById("btnAddPerson").addEventListener("click",btnAddPerson);//add event listener to button;
function btnAddPerson(){
    document.getElementById("formAddPerson").style.display='block';
};
