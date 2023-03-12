// Call the dataTables jQuery plugin
$(document).ready(function () {
  //on ready
});

async function registerUser() {

  let data = {};
  data.name = document.querySelector("#name").value;
  data.lastname = document.querySelector("#lastname").value;
  data.email = document.querySelector("#email").value;
  data.password = document.querySelector("#password").value;

  let repeatPass = document.querySelector("#passwordRepeat").value;
  if (repeatPass != data.password) {
    alert("Las Contraseñas no coinciden");
    return;
  }


  

  const request = await fetch(`api/v1/user`, {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  });
  const users = await request.json();

}

