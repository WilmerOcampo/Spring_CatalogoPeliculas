function actorSelected(select){
    let index = select.selectedIndex;
    let option = select.options[index];
    let id = option.value;
    let name = option.text;
    let urlImg = option.dataset.url;

    option.disabled = "disabled";
    select.selectedIndex = 0;

    addActor(id, name, urlImg)

    let ids = $("#ids").val();

    if (ids == ""){
        $("#ids").val(id);
    } else {
        $("#ids").val(ids + ", " + id);
    }
}

function addActor(id, name, urlImg){
    let htmlString = `
        <div class="card col-md-3 m-2" style="width: 10rem">
            <img src="{URL-IMG}" class="card-img-top actor-img" >
            <div class="card-body">
                <p class="card-text">{NAME}</p>
                <button class="btn btn-danger" data-id="{ID}" onclick="deleteActor(this); return false;">Eliminar</button>  
            </div>
        </div> `;

    htmlString = htmlString.replace("{URL-IMG}", urlImg);
    htmlString = htmlString.replace("{NAME}", name);
    htmlString = htmlString.replace("{ID}", id);

    $("#actors-container").append(htmlString);
}

function deleteActor(btn){
    let id = btn.dataset.id;
    let node = btn.parentElement.parentElement;
    let arrayIds = $("#ids").val().split(", ").filter(idActor => idActor != id);
    //1,2,3,4 => [1,2,3,4] => [1,2,4]

    $("#ids").val(arrayIds.join(", "));

    $("#actors option[value='"+ id + "']").prop("disabled", false);

    $(node).remove();
}

/*function imgPreview(){
    let reader = new FileReader();

    reader.readAsDataURL(document.getElementById("cover").files[0]);

    reader.onload = function (e){
        let view = document.getElementById("img-preview");
        view.classList.remove("d-none");
        view.style.backgroundImage = 'url("' + e.target.result + '")';
    }
}*/

function coverView() {
    let url = document.getElementById("cover").value;
    let cover = document.getElementById("cover-preview");

    cover.onload = function() {
        console.log("La imagen se ha cargado correctamente.");
    };

    cover.src = url;

    // Cargar la imagen cuando la página se carga por primera vez (opcional)
    window.onload = coverView;
}
