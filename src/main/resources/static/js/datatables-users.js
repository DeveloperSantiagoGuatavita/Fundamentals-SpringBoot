// Call the dataTables jQuery plugin
$(document).ready(function() {
  loadUsers();
  $('#dataTableUsers').DataTable();
});

async function loadUsers() {
    const request = await fetch(`api/v1/users`, {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
    });
    const users = await request.json();

    let listHTML = '';

    for(let user of users) {
      let btnDelete = '<a href="#" onclick="deleteUser(' + user.id + ')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>';
      let textPhone = user.phone != null ? user.phone : "No hay telefono disponible";
      let userHTML = '<tr><td>'+user.name+'</td><td>'+user.lastname+'</td><td>'+user.email+'</td><td>'+textPhone+'</td><td>'+user.password+'</td><td>'+btnDelete+'</td></tr>';
      listHTML += userHTML;
    }
    document.querySelector("#dataTableUsers tbody").outerHTML = listHTML;
  
    console.log(users);
  }

  async function deleteUser(id) {

    if (!confirm("¿Desea eliminar el usuario?")) {
      return;
    }

    const request = await fetch(`api/v1/user/${id}`, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
    });
    location.reload();
  }
