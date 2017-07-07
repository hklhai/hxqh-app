<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/main.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/index.css" type="text/css" media="screen" />
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/tendina.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/AL-index.js"></script>
</head>
<body>
<!--顶部-->
<div class="header">
	<div class="admin">
		<a href="#">
			<i class="icon-down"></i>
			<span>admin</span>
			<img src="${ctx}/imgs/none_user.gif" class="admin-img" />
		</a>
		<ul class="admin-down-ul" style="display: none;">
			<li>
				<a href="">
				    <i class="icon-set icon-user"></i>
					Settings
				</a>
			</li>
			<div class="line"></div>
			<li>
				<a href="${ctx}/system/logout">
					<i class="icon-logout icon-user"></i>
					LogOut
				</a>
			</li>
		</ul>
	</div>
</div>
<!--顶部结束-->
<!--菜单-->
<div class="left-menu">
	<ul id="menu">
		<li class="menu-list">
			<a style="border-top: none;" target="menuFrame" class="firsta" ><i  class="first-a-icon"></i>Openstreetmap<i class="first-a-down"></i></a>
			<ul>
				<li class="menu-list"> <a  href="${ctx}/ano/map" target="menuFrame" class="firsta"><i  class="glyph-icon icon-chevron-right3"></i>Center Map<span class="sz"></span></a></li>
				<li><a id="list82" href="${ctx}/ano/ano82" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>2. Gamas</a></li>
				<li><a id="list81" href="${ctx}/ano/ano81" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>1. AWAS</a></li>
			</ul>
		</li>

		<%--<li class="menu-list">--%>
			<%--<a target="menuFrame" class="firsta" ><i  class="glyph-icon jggl"></i>Security<span class="sz"></span></a>--%>
			<%--<ul>--%>
				<%--<li><a href="${ctx}/author/list" target="menuFrame" class="firsta"><i  class="glyph-icon icon-chevron-right2"></i>Regular Tasks<span class="sz"></span></a></li>--%>
				<%--<li><a href="${ctx}/organization/list" target="menuFrame" class="firsta" ><i  class="glyph-icon icon-chevron-right2"></i>User Role<span class="sz"></span></a></li>--%>
				<%--<li><a href="${ctx}/organization/list" target="menuFrame" class="firsta" ><i  class="glyph-icon icon-chevron-right2"></i>Athorization Mgt<span class="sz"></span></a></li>--%>
				<%--<li><a href="${ctx}/organization/list" target="menuFrame" class="firsta" ><i  class="glyph-icon icon-chevron-right2"></i>Menu Configure<span class="sz"></span></a></li>--%>
				<%--<li><a href="${ctx}/organization/list" target="menuFrame" class="firsta" ><i  class="glyph-icon icon-chevron-right2"></i>Customer ranking<span class="sz"></span></a></li>--%>
				<%--<li><a href="${ctx}/organization/list" target="menuFrame" class="firsta" ><i  class="glyph-icon icon-chevron-right2"></i>Function Button<span class="sz"></span></a></li>--%>
				<%--<li><a href="${ctx}/organization/list" target="menuFrame" class="firsta" ><i  class="glyph-icon icon-chevron-right2"></i>Appllication Designer<span class="sz"></span></a></li>--%>
				<%--<li><a href="${ctx}/organization/list" target="menuFrame" class="firsta" ><i  class="glyph-icon icon-chevron-right2"></i>Cron Task<span class="sz"></span></a></li>--%>
				<%--<li><a href="${ctx}/organization/list" target="menuFrame" class="firsta" ><i  class="glyph-icon icon-chevron-right2"></i>Sqlmary<span class="sz"></span></a></li>s--%>
			<%--</ul>--%>
		<%--</li>--%>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>IOC WIFI<i class="first-a-down"></i></a>
			<ul>
				<li><a id ="ioc95" href="${ctx}/wifi/wifi" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>4. Wifi Traffic</a></li>
				<li><a id ="list102" href="${ctx}/wifi/number" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>2. Number of Access Point</a></li>
				<li><a id ="list103" href="${ctx}/wifi/ticket" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>1. Wifi Ticket Monitoring</a></li>
				<li><a href="http://180.252.2.198/cacti/plugins/monitor/monitor.php?username=noc&password=moklet13254" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>8. FWAG & Controller</a></li>

				<li><a id ="ioc104" href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>9. Daily Ticket Distribution</a></li>
				<li><a id="list98" href="${ctx}/wifi/distribution" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>6. Distribution Status Report</a></li>
				<li><a id="list96" href="${ctx}/wifi/mttr" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>5. MTTR Targets</a></li>
                <li><a id="list100" href="${ctx}/wifi/monitoring" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>8. Monitoring MTTR Proactive</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>3. Akses Point DES </a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>IOC DashBoard<i class="first-a-down"></i></a>
			<ul>
				<li><a id="list13" href="${ctx}/digital/13" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-13</a></li>
				<li><a id="list14" href="${ctx}/digital/14" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-14</a></li>
				<li><a href="https://rafi.upoint.co.id/login" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>testurl</a></li>
				<li><a id="list17" href="${ctx}/digital/17" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-17</a></li>
				<li><a id="lsit18" href="${ctx}/digital/18" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-18</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>shangchuan</a></li>
				<li><a href="https://dashboard.telkom.co.id/idwifi" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Wifi Map</a></li>
				<li><a href="http://180.252.2.198/cacti/plugins/monitor/monitor.php?username=noc&password=moklet13254" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>WAG & Controller</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>EVENT BUMN LABUHAN BAJO</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>IOC ENTERPRISE<i class="first-a-down"></i></a>
			<ul>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-22,23,24-B-1</a></li>
				<li><a href="${ctx}/enterprise/enterpriseBussiness" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-Business</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-Government</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-22,23,24-B-2</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-22,23,24-B-4</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-Enterprise</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-26,27,28-G-1</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-26,27,28-G-2</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-26,27,28-G-4</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-30,31,32-E-1</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-30,31,32-E-2</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-30,31,32-E-4</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>IOC CUSTOMER FB<i class="first-a-down"></i></a>
			<ul>
				<li><a href="https://app.brandfibres.com/login" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>1. Summary</a></li>
				<li><a href="https://app.brandfibres.com/dashboards/59192ea188c9ffdd1fd3a676" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>2. Indihome</a></li>
				<li><a href="https://app.brandfibres.com/dashboards/591965d788c9ffdd1fd3a6a3" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>3. Wifi ID</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>4. Telkom Solution</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>IOC MOBILE<i class="first-a-down"></i></a>
			<ul>
				<li><a id="85" href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>1. Backhaul TTC Tsel National</a></li>
				<li><a id="list87" href="${ctx}/mobile/mobile87" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>MOB-87</a></li>
				<li><a id="list86" href="${ctx}/mobile/mobile86" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>MOB-86</a></li>
				<li><a id="list88" href="${ctx}/mobile/mobile88" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>MOB-88</a></li>
				<li><a id="list91" href="${ctx}/mobile/mobile91" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>MOB-91</a></li>
				<li><a id="list90" href="http://pm.telkom.co.id:8181/pc/desktop/page" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>MOB-90</a></li>
				<li><a id="list92" href="${ctx}/mobile/mobile92" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>MOB-92</a></li>
				<li><a id="list" href="http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=55a496385e87d5ad301e" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>MOB-89</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>IOC DIGITAL<i class="first-a-down"></i></a>
			<ul>
				<%--<li><a id="list13" href="${ctx}/digital/13" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-13</a></li>--%>
				<%--<li><a id="list14" href="${ctx}/digital/14" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-14</a></li>--%>
				<li><a id="DIG-15" href="https://rafi.upoint.co.id/?username=cfuds&password=cfuds" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-15</a></li>
				<%--<li><a id="list17" href="${ctx}/digital/17" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-17</a></li>--%>
				<%--<li><a id="lsit18" href="${ctx}/digital/18" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-18</a></li>--%>
				<li><a id="DIG-19" href="https://rafi.upoint.co.id/?username=cfuds&password=cfuds" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-19</a></li>
				<li><a id="list13,14,17,18" href="${ctx}/digital/13141718" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>1. Digital Operational</a></li>
				<li><a id="DIG-16,20" href="http://dashboard.melon.co.id/home" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-16,20</a></li>
			</ul>
		</li>
		<%--<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>IOC ANO<i class="first-a-down"></i></a>
			<ul>
				<li><a id="list81" href="${ctx}/ano/ano81" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ANO-81</a></li>
				<li><a id="list82" href="${ctx}/ano/ano82" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ANO-82</a></li>
			</ul>
		</li>--%>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>IOC WHOLESALE INT'L<i class="first-a-down"></i></a>
			<ul>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>WHO-34,35,36-OLO-1</a></li>
			</ul>
		</li>
	</ul>
</div>
<!--菜单右边的iframe页面-->
<div id="right-content" class="right-content">
	<div class="content">
		<div class="right-header">
			<a href="#"><i class="home-icon"></i>My portal</a>
			<span></span>
		</div>
		<div class="router">
			<span>My portal</span>
		</div>
		<div id="page_content">
			<iframe id="menuFrame" name="menuFrame" style="overflow:visible;"
					width="100%" height="100%"  src="${ctx}/wifi/daily"></iframe>
		</div>
	</div>
</div>
</body>
<script>
	$(function(){
		var contentH = document.body.clientHeight-$(".header").height();
		var iframeH = document.body.clientHeight-$(".header").height()-$(".right-header").height()-$(".router").height();
		$(".right-content").height(contentH);
		$(".content").height(contentH);
        $("#page_content").height(iframeH);
	});
</script>
</html>