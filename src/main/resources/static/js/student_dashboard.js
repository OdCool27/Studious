/*=================================================
        CHANGE VIEWS - NAVIGATION
====================================================*/

const options = document.querySelectorAll('.icon');
const views = document.querySelectorAll('.view'); // all views share this class

options.forEach((icon, index) => {
    icon.addEventListener('click', () => {

        // icon active state
        options.forEach(i => i.classList.remove('active'));
        icon.classList.add('active');

        // view visibility
        views.forEach(v => v.style.display = 'none');
        views[index].style.display = 'block';
    });
});


/*=================================================
        EDIT PROFILE - TOGGLE PROFILE WINDOW AND MORE
====================================================*/
const profile = document.querySelector('.profile-info');
const overlay = document.querySelector('.overlay');
const exitProfileWindow = document.querySelector('.close-window');

exitProfileWindow.addEventListener('click', function (e) {
    overlay.classList.add("inactive");
    setTimeout(() => {
        overlay.style.display = 'none';
    }, 400);
})

profile.addEventListener('click', function (e) {
    overlay.style.display = 'flex';
    overlay.classList.remove("inactive");
})