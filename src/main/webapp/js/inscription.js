function showMe (box) {

    var chboxs = document.getElementsByName("participant");
    var vis = "none";
    for(var i=0;i<chboxs.length;i++) { 
        if(chboxs[i].checked){
         vis = "block";
            break;
        }
    }
    document.getElementById(box).style.display = vis;
}

/* function VerifForm(){   
	var AllIsOk=0;
 
                             // ici une serie de tests : (exmple si les champs sont vides)
    if(document.forms['myform'].elements['monchamps1'].value==''){AllIsOk++;}
    if(document.forms['myform'].elements['monchamps2'].value==''){AllIsOk++;}
 
                             //ici le retour de la fonction
 
                             // return (AllIsOk==0);
                              //retourne true si tous les champs sont remplis
    if(AllIsOk !=0){
    	alert
    }  */