<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">SimpleDMS</a>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNavDropdown"
        aria-controls="navbarNavDropdown"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <!-- 대메뉴1 -->
        <ul class="navbar-nav">
          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdownMenuLink"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              Department Info
            </a>
            <!-- 소메뉴 정의  -->
            <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
              <li><router-link to="/dept" class="dropdown-item">Dept</router-link></li>
              <li><router-link to="/add/dept" class="dropdown-item">Add</router-link></li>
            </ul>
          </li>
        </ul>
        <!-- 대메뉴2 -->
        <ul class="navbar-nav">
          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdownMenuLink"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              Employee Info
            </a>

            <!-- 소메뉴 정의  -->
            <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
              <li><router-link to="/emp" class="dropdown-item">Emp</router-link></li>
              <li><router-link to="/add/emp" class="dropdown-item">Add</router-link></li>
            </ul>
          </li>
        </ul>

        <!-- 대메뉴3 -->
        <ul class="navbar-nav">
          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdownMenuLink"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              Faq Info
            </a>
            <!-- 소메뉴 정의  -->
            <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
              <li><router-link to="/faq" class="dropdown-item">Faq</router-link></li>
              <li><router-link to="/add/faq" class="dropdown-item">Add</router-link></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <!-- container: 화면에 중앙정렬과 외곽선 없는 박스 형 / mt(Margin Top) 1~5까지 부트스트랩에서 선어되어 있음 -->
  <div class="container mt-3">
    <router-view />
  </div>
  <!-- router-view: 메뉴를 클릭하면 화면에 보이는 부분 -->
</template>

<style lang="scss"></style>
