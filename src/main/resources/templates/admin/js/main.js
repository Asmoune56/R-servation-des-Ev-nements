// js/main.js
export function getToken() {
    return localStorage.getItem("token");
}

export function authHeaders() {
    return {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + getToken()
    };
}

export async function fetchData(url, method = 'GET', body = null) {
    const options = {
        method,
        headers: authHeaders(),
    };
    if (body) options.body = JSON.stringify(body);
    const res = await fetch(url, options);
    return await res.json();
}
