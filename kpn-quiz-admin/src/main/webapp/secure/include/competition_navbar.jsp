<div class="navbar-content">
    <div class="main-navigation navbar-collapse collapse">
        <div class="navigation-toggler">
            <i class="clip-chevron-left"></i>
            <i class="clip-chevron-right"></i>
        </div>
        <ul class="main-navigation-menu">
            <li>
                <a href="${pageContext.request.contextPath}/secure/index"><i class="clip-home-3"></i>
                    <span class="title"> Dashboard </span><span class="selected"></span>
                </a>
            </li>
            <li class="active open">
                <a href="javascript:void(0)"><i class="clip-pencil"></i>
                    <span class="title"> Manage Competition </span><i class="icon-arrow"></i>
                    <span class="selected"></span>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a href="${pageContext.request.contextPath}/secure/competition/register">
                            <span class="title">Register</span>
                        </a>
                    </li>
                </ul>
                <ul class="sub-menu">
                    <li>
                        <a href="${pageContext.request.contextPath}/secure/competition/list">
                            <span class="title">Competition List</span>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>