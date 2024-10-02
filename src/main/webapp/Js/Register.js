// Verificar si hay un parámetro de error o éxito en la URL
const urlParams = new URLSearchParams(window.location.search);

// Mostrar alerta de éxito
if (urlParams.get('success') === 'true') {
    Swal.fire({
        icon: 'success',
        title: 'Registro Exitoso',
        text: 'Te has registrado correctamente.',
        confirmButtonText: 'Ok'
    }).then(() => {
        window.location.href = 'index.jsp';
    });
}

// Mostrar alerta de error si username o email ya están registrados
if (urlParams.get('error') === 'true') {
    Swal.fire({
        icon: 'error',
        title: 'Error de Registro',
        text: 'El nombre de usuario o correo electrónico ya están registrados.',
        confirmButtonText: 'Ok'
    });
}

function handleCredentialResponse(response) {
    // Aquí puedes manejar la respuesta del token
    const idToken = response.credential;

    // Enviar el token al servidor para su verificación
    fetch('googleLoginServlet', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ idToken: idToken })
    })
        .then(res => res.json())
        .then(data => {
            if (data.success) {
                window.location.href = 'index.jsp'; // Redirecciona al inicio
            } else {
                alert('Error al iniciar sesión con Google');
            }
        });
}