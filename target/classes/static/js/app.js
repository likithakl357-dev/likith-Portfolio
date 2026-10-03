const projectGrid = document.getElementById('projectGrid');
const projectSearch = document.getElementById('projectSearch');
const filterList = document.getElementById('filterList');
let projects = [];
let activeFilter = 'All';

const glyphs = {
  'Machine Learning': '✳',
  'Embedded Systems': '⌁',
  'Communication Systems': '⌁',
  'Signal Processing': '∿',
  'Digital & Analog Electronics': '◫',
  'PCB Design': '▦',
  'Java': '☕'
};

function escapeHTML(value = '') {
  return String(value).replace(/[&<>"']/g, char => ({
    '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;'
  })[char]);
}

function renderProjects() {
  const query = projectSearch.value.trim().toLowerCase();
  const filtered = projects.filter(project => {
    const matchesCategory = activeFilter === 'All' || project.category === activeFilter;
    const searchable = `${project.title} ${project.category} ${project.stack} ${project.description}`.toLowerCase();
    return matchesCategory && searchable.includes(query);
  });

  if (!filtered.length) {
    projectGrid.innerHTML = '<div class="empty-state">No projects match that search. Try another keyword or category.</div>';
    return;
  }

  projectGrid.innerHTML = filtered.map(project => `
    <article class="project-card">
      <div class="project-top">
        <span class="project-category">${escapeHTML(project.category)}</span>
        <span class="project-glyph" aria-hidden="true">${glyphs[project.category] || '◇'}</span>
      </div>
      <h3>${escapeHTML(project.title)}</h3>
      <p>${escapeHTML(project.description)}</p>
      <div class="project-stack">${escapeHTML(project.stack)}</div>
      <a class="project-link" href="${escapeHTML(project.url)}" target="_blank" rel="noopener noreferrer">
        View repository <span>↗</span>
      </a>
    </article>
  `).join('');
}

async function loadProjects() {
  try {
    const response = await fetch('/api/projects');
    if (!response.ok) throw new Error('Project API unavailable');
    projects = await response.json();
    renderProjects();
  } catch (error) {
    projectGrid.innerHTML = '<div class="empty-state">Projects could not load. Start the Spring Boot application and refresh this page.</div>';
    console.error(error);
  }
}

projectSearch.addEventListener('input', renderProjects);
filterList.addEventListener('click', event => {
  const button = event.target.closest('button[data-filter]');
  if (!button) return;
  activeFilter = button.dataset.filter;
  filterList.querySelectorAll('.filter').forEach(item => item.classList.toggle('active', item === button));
  renderProjects();
});

const menuToggle = document.getElementById('menuToggle');
const nav = document.getElementById('nav');
menuToggle.addEventListener('click', () => {
  const open = nav.classList.toggle('open');
  menuToggle.setAttribute('aria-expanded', String(open));
});
nav.querySelectorAll('a').forEach(link => link.addEventListener('click', () => {
  nav.classList.remove('open');
  menuToggle.setAttribute('aria-expanded', 'false');
}));

const observer = new IntersectionObserver(entries => {
  entries.forEach(entry => {
    if (entry.isIntersecting) {
      entry.target.classList.add('visible');
      observer.unobserve(entry.target);
    }
  });
}, { threshold: 0.12 });
document.querySelectorAll('.reveal').forEach(element => observer.observe(element));

document.getElementById('year').textContent = new Date().getFullYear();
loadProjects();
