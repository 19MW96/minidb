function speichern() {
    let name = document.getElementById("name").value;
    let nummer = document.getElementById("nummer").value;
    fetch("/kontakte/" + name, { method: "PUT", body: nummer });
    document.getElementById("ergebnis").innerText = name + " gespeichert";
}

async function suchen() {
    let name = document.getElementById("name").value;
    let antwort = await fetch("/kontakte/" + name);
    let nummer = await antwort.text();
    document.getElementById("ergebnis").innerText = nummer;
}

async function alleAnzeigen() {
    let antwort = await fetch("/kontakte");
    let liste = await antwort.text();
    document.getElementById("ergebnis").innerText = liste;
}