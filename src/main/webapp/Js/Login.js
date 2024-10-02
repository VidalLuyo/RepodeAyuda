const urlParams = new URLSearchParams(window.location.search);

if (urlParams.get('success') === 'true') {
    Swal.fire({
        icon: 'success',
        title: 'Inicio de Sesión Correcto',
        text: 'Iniciaste sesión correctamente.',
        confirmButtonText: 'Ok'
    }).then(() => {
        window.location.href = 'Acciones.jsp';
    });
}

if (urlParams.get('error') === 'true') {
    Swal.fire({
        icon: 'error',
        title: 'Error de Inicio de Sesión',
        text: 'Correo electrónico, nombre de usuario o contraseña incorrectos.',
        confirmButtonText: 'Ok'
    });
}


