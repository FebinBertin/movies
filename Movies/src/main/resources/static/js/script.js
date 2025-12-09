// JS for Movie App

// Auto dismiss alerts after 3 seconds
setTimeout(() => {
    let alerts = document.querySelectorAll(".alert");
    alerts.forEach(alert => alert.style.display = "none");
}, 3000);

// Movie hover effect color change (optional)
document.querySelectorAll(".movie-card").forEach(card => {
    card.addEventListener("mouseenter", () => {
        card.style.border = "2px solid #0d6efd";
    });
    card.addEventListener("mouseleave", () => {
        card.style.border = "none";
    });
});