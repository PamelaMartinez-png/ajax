
function listarCategorias() {
  $.ajax({
    method: "GET",
    url: "/productos/api/categorias",
    data: {},
    success: function (categorias) {
      let tabla = new DataTable('#exampleCategorias');
      tabla.clear().draw();

      categorias.forEach(categoria => {
        let botones = `<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-update-categoria" onclick="identificaActualizarCategoria(${categoria.id})"> Editar </button>`;
        botones += ` <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modal-delete-categoria" onclick="identificaEliminarCategoria(${categoria.id})">Eliminar</button>`;

        tabla.row
            .add([categoria.id, categoria.nombre, botones])
            .draw()
            .node().id = 'renglon_cat_' + categoria.id;
      });
    },
    error: function (error) {
      console.error("Error al listar categorías:", error);
    }
  });
}

function guardarCategoria() {
  let nombreCat = document.getElementById('nombre-categoria').value;

  if (!nombreCat) {
    alert("Por favor, ingrese el nombre de la categoría");
    return;
  }

  $.ajax({
    method: 'POST',
    url: "/productos/api/categorias",
    contentType: "application/json",
    data: JSON.stringify({
      nombre: nombreCat
    }),
    success: function (categoria) {
      let botones = `<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-update-categoria" onclick="identificaActualizarCategoria(${categoria.id})"> Editar </button>`;
      botones += ` <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modal-delete-categoria" onclick="identificaEliminarCategoria(${categoria.id})">Eliminar</button>`;

      let tabla = new DataTable("#exampleCategorias");
      tabla.row
          .add([categoria.id, categoria.nombre, botones])
          .draw()
          .node().id = 'renglon_cat_' + categoria.id;

      alert("Categoría guardada correctamente");
      document.getElementById('nombre-categoria').value = "";
      $('#modal-add-categoria').modal('hide');
    }
  });
}

function identificaActualizarCategoria(id) {
  $.ajax({
    method: 'GET',
    url: "/productos/api/categorias/" + id,
    success: function (categoria) {
      document.getElementById('id-update-categoria').value = categoria.id;
      document.getElementById('nombre-update-categoria').value = categoria.nombre;
    }
  });
}

function actualizarCategoria() {
  let idCat = document.getElementById('id-update-categoria').value;
  let nombreCat = document.getElementById('nombre-update-categoria').value;

  $.ajax({
    method: 'PUT',
    url: "/productos/api/categorias/" + idCat,
    contentType: 'application/json',
    data: JSON.stringify({
      nombre: nombreCat
    }),
    success: function () {
      let tabla = new DataTable("#exampleCategorias");
      let datos = tabla.row("#renglon_cat_" + idCat).data();
      datos[1] = nombreCat;

      tabla.row("#renglon_cat_" + idCat).data(datos).draw();
      alert('Categoría actualizada correctamente');
      $('#modal-update-categoria').modal('hide');
    }
  });
}

function identificaEliminarCategoria(id) {
  $.ajax({
    method: 'GET',
    url: "/productos/api/categorias/" + id,
    success: function (categoria) {
      document.getElementById('id-delete-categoria').value = categoria.id;
      document.getElementById('nombre-delete-categoria').value = categoria.nombre;
    }
  });
}

function eliminarCategoria() {
  let idCat = document.getElementById('id-delete-categoria').value;

  $.ajax({
    method: 'DELETE',
    url: "/productos/api/categorias/" + idCat,
    success: function () {
      alert('Categoría eliminada');
      let tabla = new DataTable('#exampleCategorias');
      tabla.row('#renglon_cat_' + idCat).remove().draw();
      $('#modal-delete-categoria').modal('hide');
    }
  });
}