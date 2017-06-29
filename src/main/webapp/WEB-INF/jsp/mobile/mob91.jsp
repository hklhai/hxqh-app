<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/mob91.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/vue.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<div id="mob91">
	<h3>SQUAT</h3>
	<div class="row">
		<div class="col-sm-6">
			<table>
				<thead>
				<tr>
					<td colspan="7">ALPHA</td>
				</tr>
				<tr>
					<td rowspan="2">TREG</td>
					<td colspan="2">TICKETS</td>
					<td colspan="2">PICKUP</td>
					<td colspan="2">COMPLY</td>
				</tr>
				<tr>
					<td>TOTAL</td>
					<td>ASSIGNED</td>
					<td>TOTAL</td>
					<td>%</td>
					<td>TOTAL</td>
					<td>%</td>
				</tr>
				</thead>
				<tbody>
				<tr>
					<td>NAS</td>
					<td>ASSIGNED</td>
					<td>TOTAL</td>
					<td>%</td>
					<td>TOTAL</td>
					<td>%</td>
					<td>%</td>
				</tr>
				<tr>
					<td>REG-1</td>
					<td>ASSIGNED</td>
					<td>TOTAL</td>
					<td>%</td>
					<td>TOTAL</td>
					<td>%</td>
					<td>%</td>
				</tr>
				</tbody>
			</table>
		</div>
		<div class="col-sm-6">
			<table>
				<thead>
					<tr>
						<td colspan="7">ALPHA</td>
					</tr>
					<tr>
						<td rowspan="2">TREG</td>
						<td colspan="2">TICKETS</td>
						<td colspan="2">PICKUP</td>
						<td colspan="2">COMPLY</td>
					</tr>
					<tr>
						<td>TOTAL</td>
						<td>ASSIGNED</td>
						<td>TOTAL</td>
						<td>%</td>
						<td>TOTAL</td>
						<td>%</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>NAS</td>
						<td>ASSIGNED</td>
						<td>TOTAL</td>
						<td>%</td>
						<td>TOTAL</td>
						<td>%</td>
						<td>%</td>
					</tr>
					<tr>
						<td>REG-1</td>
						<td>ASSIGNED</td>
						<td>TOTAL</td>
						<td>%</td>
						<td>TOTAL</td>
						<td>%</td>
						<td>%</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/mob91.js"></script>
</html>