<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
<meta charset="utf-8">


<link href="/swp/js/fullcalender/fullcalendar.min.css" rel="stylesheet">
<link href="/swp/js/fullcalender/fullcalendar.print.min.css" rel="stylesheet" media="print">
<script src="/swp/js/fullcalender/lib/moment.min.js"></script>
<script src="/swp/js/fullcalender/lib/jquery.min.js"></script>
<script src="/swp/js/fullcalender/fullcalendar.min.js"></script>



<link href="../fullcalendar.css" rel="stylesheet">
<link href="../fullcalendar.print.css" rel="stylesheet" media="print">
<script src="../lib/moment.min.js"></script>
<script src="../lib/jquery.min.js"></script>
<script src="../fullcalendar.min.js"></script>
<script>
	$(document).ready(function() {

		$('#calendar').fullCalendar({
			header : {
				left : 'prev,next today',
				center : 'title',
				right : 'month,agendaWeek,agendaDay,listWeek'
			},
			defaultDate : '2016-09-12',
			navLinks : true, // can click day/week names to navigate views
			editable : true,
			eventLimit : true, // allow "more" link when too many events
			events : [ {
				title : 'All Day Event',
				start : '2016-09-01'
			}, {
				title : 'Long Event',
				start : '2016-09-07',
				end : '2016-09-10'
			}, {
				id : 999,
				title : 'Repeating Event',
				start : '2016-09-09T16:00:00'
			}, {
				id : 999,
				title : 'Repeating Event',
				start : '2016-09-16T16:00:00'
			}, {
				title : 'Conference',
				start : '2016-09-11',
				end : '2016-09-13'
			}, {
				title : 'Meeting',
				start : '2016-09-12T10:30:00',
				end : '2016-09-12T12:30:00'
			}, {
				title : 'Lunch',
				start : '2016-09-12T12:00:00'
			}, {
				title : 'Meeting',
				start : '2016-09-12T14:30:00'
			}, {
				title : 'Happy Hour',
				start : '2016-09-12T17:30:00'
			}, {
				title : 'Dinner',
				start : '2016-09-12T20:00:00'
			}, {
				title : 'Birthday Party',
				start : '2016-09-13T07:00:00'
			}, {
				title : 'Click for Google',
				url : 'http://google.com/',
				start : '2016-09-28'
			} ]
		});

	});
</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 0 auto;
}
</style>
</head>
<body>

	<div id="calendar" class="fc fc-unthemed fc-ltr">
		<div class="fc-toolbar">
			<div class="fc-left">
				<div class="fc-button-group">
					<button type="button"
						class="fc-prev-button fc-button fc-state-default fc-corner-left">
						<span class="fc-icon fc-icon-left-single-arrow"></span>
					</button>
					<button type="button"
						class="fc-next-button fc-button fc-state-default fc-corner-right">
						<span class="fc-icon fc-icon-right-single-arrow"></span>
					</button>
				</div>
				<button type="button"
					class="fc-today-button fc-button fc-state-default fc-corner-left fc-corner-right">today</button>
			</div>
			<div class="fc-right">
				<div class="fc-button-group">
					<button type="button"
						class="fc-month-button fc-button fc-state-default fc-corner-left fc-state-active">month</button>
					<button type="button"
						class="fc-agendaWeek-button fc-button fc-state-default">week</button>
					<button type="button"
						class="fc-agendaDay-button fc-button fc-state-default">day</button>
					<button type="button"
						class="fc-listWeek-button fc-button fc-state-default fc-corner-right">list</button>
				</div>
			</div>
			<div class="fc-center">
				<h2>September 2016</h2>
			</div>
			<div class="fc-clear"></div>
		</div>
		<div class="fc-view-container" style="">
			<div class="fc-view fc-month-view fc-basic-view" style="">
				<table>
					<thead class="fc-head">
						<tr>
							<td class="fc-head-container fc-widget-header"><div
									class="fc-row fc-widget-header"
									style="border-right-width: 1px; margin-right: -0.599976px;">
									<table>
										<thead>
											<tr>
												<th class="fc-day-header fc-widget-header fc-sun"><span>Sun</span></th>
												<th class="fc-day-header fc-widget-header fc-mon"><span>Mon</span></th>
												<th class="fc-day-header fc-widget-header fc-tue"><span>Tue</span></th>
												<th class="fc-day-header fc-widget-header fc-wed"><span>Wed</span></th>
												<th class="fc-day-header fc-widget-header fc-thu"><span>Thu</span></th>
												<th class="fc-day-header fc-widget-header fc-fri"><span>Fri</span></th>
												<th class="fc-day-header fc-widget-header fc-sat"><span>Sat</span></th>
											</tr>
										</thead>
									</table>
								</div></td>
						</tr>
					</thead>
					<tbody class="fc-body">
						<tr>
							<td class="fc-widget-content"><div
									class="fc-scroller fc-day-grid-container"
									style="overflow-x: hidden; overflow-y: scroll; height: 577.8px;">
									<div class="fc-day-grid fc-unselectable">
										<div class="fc-row fc-week fc-widget-content fc-rigid"
											style="height: 96px;">
											<div class="fc-bg">
												<table>
													<tbody>
														<tr>
															<td
																class="fc-day fc-widget-content fc-sun fc-other-month fc-past"
																data-date="2016-08-28"></td>
															<td
																class="fc-day fc-widget-content fc-mon fc-other-month fc-past"
																data-date="2016-08-29"></td>
															<td
																class="fc-day fc-widget-content fc-tue fc-other-month fc-past"
																data-date="2016-08-30"></td>
															<td
																class="fc-day fc-widget-content fc-wed fc-other-month fc-past"
																data-date="2016-08-31"></td>
															<td class="fc-day fc-widget-content fc-thu fc-past"
																data-date="2016-09-01"></td>
															<td class="fc-day fc-widget-content fc-fri fc-past"
																data-date="2016-09-02"></td>
															<td class="fc-day fc-widget-content fc-sat fc-past"
																data-date="2016-09-03"></td>
														</tr>
													</tbody>
												</table>
											</div>
											<div class="fc-content-skeleton">
												<table>
													<thead>
														<tr>
															<td class="fc-day-top fc-sun fc-other-month fc-past"
																data-date="2016-08-28"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-08-28&quot;,&quot;type&quot;:&quot;day&quot;}">28</a></td>
															<td class="fc-day-top fc-mon fc-other-month fc-past"
																data-date="2016-08-29"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-08-29&quot;,&quot;type&quot;:&quot;day&quot;}">29</a></td>
															<td class="fc-day-top fc-tue fc-other-month fc-past"
																data-date="2016-08-30"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-08-30&quot;,&quot;type&quot;:&quot;day&quot;}">30</a></td>
															<td class="fc-day-top fc-wed fc-other-month fc-past"
																data-date="2016-08-31"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-08-31&quot;,&quot;type&quot;:&quot;day&quot;}">31</a></td>
															<td class="fc-day-top fc-thu fc-past"
																data-date="2016-09-01"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-01&quot;,&quot;type&quot;:&quot;day&quot;}">1</a></td>
															<td class="fc-day-top fc-fri fc-past"
																data-date="2016-09-02"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-02&quot;,&quot;type&quot;:&quot;day&quot;}">2</a></td>
															<td class="fc-day-top fc-sat fc-past"
																data-date="2016-09-03"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-03&quot;,&quot;type&quot;:&quot;day&quot;}">3</a></td>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td></td>
															<td></td>
															<td></td>
															<td></td>
															<td class="fc-event-container"><a
																class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable fc-resizable"><div
																		class="fc-content">
																		<span class="fc-title">All Day Event</span>
																	</div>
																	<div class="fc-resizer fc-end-resizer"></div></a></td>
															<td></td>
															<td></td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
										<div class="fc-row fc-week fc-widget-content fc-rigid"
											style="height: 96px;">
											<div class="fc-bg">
												<table>
													<tbody>
														<tr>
															<td class="fc-day fc-widget-content fc-sun fc-past"
																data-date="2016-09-04"></td>
															<td class="fc-day fc-widget-content fc-mon fc-past"
																data-date="2016-09-05"></td>
															<td class="fc-day fc-widget-content fc-tue fc-past"
																data-date="2016-09-06"></td>
															<td class="fc-day fc-widget-content fc-wed fc-past"
																data-date="2016-09-07"></td>
															<td class="fc-day fc-widget-content fc-thu fc-past"
																data-date="2016-09-08"></td>
															<td class="fc-day fc-widget-content fc-fri fc-past"
																data-date="2016-09-09"></td>
															<td class="fc-day fc-widget-content fc-sat fc-past"
																data-date="2016-09-10"></td>
														</tr>
													</tbody>
												</table>
											</div>
											<div class="fc-content-skeleton">
												<table>
													<thead>
														<tr>
															<td class="fc-day-top fc-sun fc-past"
																data-date="2016-09-04"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-04&quot;,&quot;type&quot;:&quot;day&quot;}">4</a></td>
															<td class="fc-day-top fc-mon fc-past"
																data-date="2016-09-05"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-05&quot;,&quot;type&quot;:&quot;day&quot;}">5</a></td>
															<td class="fc-day-top fc-tue fc-past"
																data-date="2016-09-06"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-06&quot;,&quot;type&quot;:&quot;day&quot;}">6</a></td>
															<td class="fc-day-top fc-wed fc-past"
																data-date="2016-09-07"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-07&quot;,&quot;type&quot;:&quot;day&quot;}">7</a></td>
															<td class="fc-day-top fc-thu fc-past"
																data-date="2016-09-08"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-08&quot;,&quot;type&quot;:&quot;day&quot;}">8</a></td>
															<td class="fc-day-top fc-fri fc-past"
																data-date="2016-09-09"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-09&quot;,&quot;type&quot;:&quot;day&quot;}">9</a></td>
															<td class="fc-day-top fc-sat fc-past"
																data-date="2016-09-10"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-10&quot;,&quot;type&quot;:&quot;day&quot;}">10</a></td>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td rowspan="2"></td>
															<td rowspan="2"></td>
															<td rowspan="2"></td>
															<td class="fc-event-container" colspan="3"><a
																class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable fc-resizable"><div
																		class="fc-content">
																		<span class="fc-title">Long Event</span>
																	</div>
																	<div class="fc-resizer fc-end-resizer"></div></a></td>
															<td rowspan="2"></td>
														</tr>
														<tr>
															<td></td>
															<td></td>
															<td class="fc-event-container"><a
																class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable"><div
																		class="fc-content">
																		<span class="fc-time">4p</span> <span class="fc-title">Repeating
																			Event</span>
																	</div></a></td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
										<div class="fc-row fc-week fc-widget-content fc-rigid"
											style="height: 96px;">
											<div class="fc-bg">
												<table>
													<tbody>
														<tr>
															<td class="fc-day fc-widget-content fc-sun fc-past"
																data-date="2016-09-11"></td>
															<td class="fc-day fc-widget-content fc-mon fc-past"
																data-date="2016-09-12"></td>
															<td class="fc-day fc-widget-content fc-tue fc-past"
																data-date="2016-09-13"></td>
															<td class="fc-day fc-widget-content fc-wed fc-past"
																data-date="2016-09-14"></td>
															<td class="fc-day fc-widget-content fc-thu fc-past"
																data-date="2016-09-15"></td>
															<td class="fc-day fc-widget-content fc-fri fc-past"
																data-date="2016-09-16"></td>
															<td class="fc-day fc-widget-content fc-sat fc-past"
																data-date="2016-09-17"></td>
														</tr>
													</tbody>
												</table>
											</div>
											<div class="fc-content-skeleton">
												<table>
													<thead>
														<tr>
															<td class="fc-day-top fc-sun fc-past"
																data-date="2016-09-11"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-11&quot;,&quot;type&quot;:&quot;day&quot;}">11</a></td>
															<td class="fc-day-top fc-mon fc-past"
																data-date="2016-09-12"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-12&quot;,&quot;type&quot;:&quot;day&quot;}">12</a></td>
															<td class="fc-day-top fc-tue fc-past"
																data-date="2016-09-13"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-13&quot;,&quot;type&quot;:&quot;day&quot;}">13</a></td>
															<td class="fc-day-top fc-wed fc-past"
																data-date="2016-09-14"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-14&quot;,&quot;type&quot;:&quot;day&quot;}">14</a></td>
															<td class="fc-day-top fc-thu fc-past"
																data-date="2016-09-15"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-15&quot;,&quot;type&quot;:&quot;day&quot;}">15</a></td>
															<td class="fc-day-top fc-fri fc-past"
																data-date="2016-09-16"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-16&quot;,&quot;type&quot;:&quot;day&quot;}">16</a></td>
															<td class="fc-day-top fc-sat fc-past"
																data-date="2016-09-17"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-17&quot;,&quot;type&quot;:&quot;day&quot;}">17</a></td>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td class="fc-event-container" colspan="2"><a
																class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable fc-resizable"><div
																		class="fc-content">
																		<span class="fc-title">Conference</span>
																	</div>
																	<div class="fc-resizer fc-end-resizer"></div></a></td>
															<td class="fc-event-container" rowspan="6"><a
																class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable"><div
																		class="fc-content">
																		<span class="fc-time">7a</span> <span class="fc-title">Birthday
																			Party</span>
																	</div></a></td>
															<td rowspan="6"></td>
															<td rowspan="6"></td>
															<td class="fc-event-container" rowspan="6"><a
																class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable"><div
																		class="fc-content">
																		<span class="fc-time">4p</span> <span class="fc-title">Repeating
																			Event</span>
																	</div></a></td>
															<td rowspan="6"></td>
														</tr>
														<tr>
															<td rowspan="5"></td>
															<td class="fc-event-container"><a
																class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable"><div
																		class="fc-content">
																		<span class="fc-time">10:30a</span> <span
																			class="fc-title">Meeting</span>
																	</div></a></td>
														</tr>
														<tr>
															<td class="fc-event-container"><a
																class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable"><div
																		class="fc-content">
																		<span class="fc-time">12p</span> <span
																			class="fc-title">Lunch</span>
																	</div></a></td>
														</tr>
														<tr>
															<td class="fc-event-container fc-limited"><a
																class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable"><div
																		class="fc-content">
																		<span class="fc-time">2:30p</span> <span
																			class="fc-title">Meeting</span>
																	</div></a></td>
															<td class="fc-more-cell" rowspan="1"><div>
																	<a class="fc-more">+3 more</a>
																</div></td>
														</tr>
														<tr class="fc-limited">
															<td class="fc-event-container"><a
																class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable"><div
																		class="fc-content">
																		<span class="fc-time">5:30p</span> <span
																			class="fc-title">Happy Hour</span>
																	</div></a></td>
														</tr>
														<tr class="fc-limited">
															<td class="fc-event-container"><a
																class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable"><div
																		class="fc-content">
																		<span class="fc-time">8p</span> <span class="fc-title">Dinner</span>
																	</div></a></td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
										<div class="fc-row fc-week fc-widget-content fc-rigid"
											style="height: 96px;">
											<div class="fc-bg">
												<table>
													<tbody>
														<tr>
															<td class="fc-day fc-widget-content fc-sun fc-past"
																data-date="2016-09-18"></td>
															<td class="fc-day fc-widget-content fc-mon fc-past"
																data-date="2016-09-19"></td>
															<td class="fc-day fc-widget-content fc-tue fc-past"
																data-date="2016-09-20"></td>
															<td class="fc-day fc-widget-content fc-wed fc-past"
																data-date="2016-09-21"></td>
															<td class="fc-day fc-widget-content fc-thu fc-past"
																data-date="2016-09-22"></td>
															<td class="fc-day fc-widget-content fc-fri fc-past"
																data-date="2016-09-23"></td>
															<td class="fc-day fc-widget-content fc-sat fc-past"
																data-date="2016-09-24"></td>
														</tr>
													</tbody>
												</table>
											</div>
											<div class="fc-content-skeleton">
												<table>
													<thead>
														<tr>
															<td class="fc-day-top fc-sun fc-past"
																data-date="2016-09-18"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-18&quot;,&quot;type&quot;:&quot;day&quot;}">18</a></td>
															<td class="fc-day-top fc-mon fc-past"
																data-date="2016-09-19"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-19&quot;,&quot;type&quot;:&quot;day&quot;}">19</a></td>
															<td class="fc-day-top fc-tue fc-past"
																data-date="2016-09-20"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-20&quot;,&quot;type&quot;:&quot;day&quot;}">20</a></td>
															<td class="fc-day-top fc-wed fc-past"
																data-date="2016-09-21"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-21&quot;,&quot;type&quot;:&quot;day&quot;}">21</a></td>
															<td class="fc-day-top fc-thu fc-past"
																data-date="2016-09-22"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-22&quot;,&quot;type&quot;:&quot;day&quot;}">22</a></td>
															<td class="fc-day-top fc-fri fc-past"
																data-date="2016-09-23"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-23&quot;,&quot;type&quot;:&quot;day&quot;}">23</a></td>
															<td class="fc-day-top fc-sat fc-past"
																data-date="2016-09-24"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-24&quot;,&quot;type&quot;:&quot;day&quot;}">24</a></td>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td></td>
															<td></td>
															<td></td>
															<td></td>
															<td></td>
															<td></td>
															<td></td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
										<div class="fc-row fc-week fc-widget-content fc-rigid"
											style="height: 96px;">
											<div class="fc-bg">
												<table>
													<tbody>
														<tr>
															<td class="fc-day fc-widget-content fc-sun fc-past"
																data-date="2016-09-25"></td>
															<td class="fc-day fc-widget-content fc-mon fc-past"
																data-date="2016-09-26"></td>
															<td class="fc-day fc-widget-content fc-tue fc-past"
																data-date="2016-09-27"></td>
															<td class="fc-day fc-widget-content fc-wed fc-past"
																data-date="2016-09-28"></td>
															<td class="fc-day fc-widget-content fc-thu fc-past"
																data-date="2016-09-29"></td>
															<td class="fc-day fc-widget-content fc-fri fc-past"
																data-date="2016-09-30"></td>
															<td
																class="fc-day fc-widget-content fc-sat fc-other-month fc-past"
																data-date="2016-10-01"></td>
														</tr>
													</tbody>
												</table>
											</div>
											<div class="fc-content-skeleton">
												<table>
													<thead>
														<tr>
															<td class="fc-day-top fc-sun fc-past"
																data-date="2016-09-25"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-25&quot;,&quot;type&quot;:&quot;day&quot;}">25</a></td>
															<td class="fc-day-top fc-mon fc-past"
																data-date="2016-09-26"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-26&quot;,&quot;type&quot;:&quot;day&quot;}">26</a></td>
															<td class="fc-day-top fc-tue fc-past"
																data-date="2016-09-27"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-27&quot;,&quot;type&quot;:&quot;day&quot;}">27</a></td>
															<td class="fc-day-top fc-wed fc-past"
																data-date="2016-09-28"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-28&quot;,&quot;type&quot;:&quot;day&quot;}">28</a></td>
															<td class="fc-day-top fc-thu fc-past"
																data-date="2016-09-29"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-29&quot;,&quot;type&quot;:&quot;day&quot;}">29</a></td>
															<td class="fc-day-top fc-fri fc-past"
																data-date="2016-09-30"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-09-30&quot;,&quot;type&quot;:&quot;day&quot;}">30</a></td>
															<td class="fc-day-top fc-sat fc-other-month fc-past"
																data-date="2016-10-01"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-10-01&quot;,&quot;type&quot;:&quot;day&quot;}">1</a></td>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td></td>
															<td></td>
															<td></td>
															<td class="fc-event-container"><a
																class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable fc-resizable"
																href="http://google.com/"><div class="fc-content">
																		<span class="fc-title">Click for Google</span>
																	</div>
																	<div class="fc-resizer fc-end-resizer"></div></a></td>
															<td></td>
															<td></td>
															<td></td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
										<div class="fc-row fc-week fc-widget-content fc-rigid"
											style="height: 97px;">
											<div class="fc-bg">
												<table>
													<tbody>
														<tr>
															<td
																class="fc-day fc-widget-content fc-sun fc-other-month fc-past"
																data-date="2016-10-02"></td>
															<td
																class="fc-day fc-widget-content fc-mon fc-other-month fc-past"
																data-date="2016-10-03"></td>
															<td
																class="fc-day fc-widget-content fc-tue fc-other-month fc-past"
																data-date="2016-10-04"></td>
															<td
																class="fc-day fc-widget-content fc-wed fc-other-month fc-past"
																data-date="2016-10-05"></td>
															<td
																class="fc-day fc-widget-content fc-thu fc-other-month fc-past"
																data-date="2016-10-06"></td>
															<td
																class="fc-day fc-widget-content fc-fri fc-other-month fc-past"
																data-date="2016-10-07"></td>
															<td
																class="fc-day fc-widget-content fc-sat fc-other-month fc-past"
																data-date="2016-10-08"></td>
														</tr>
													</tbody>
												</table>
											</div>
											<div class="fc-content-skeleton">
												<table>
													<thead>
														<tr>
															<td class="fc-day-top fc-sun fc-other-month fc-past"
																data-date="2016-10-02"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-10-02&quot;,&quot;type&quot;:&quot;day&quot;}">2</a></td>
															<td class="fc-day-top fc-mon fc-other-month fc-past"
																data-date="2016-10-03"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-10-03&quot;,&quot;type&quot;:&quot;day&quot;}">3</a></td>
															<td class="fc-day-top fc-tue fc-other-month fc-past"
																data-date="2016-10-04"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-10-04&quot;,&quot;type&quot;:&quot;day&quot;}">4</a></td>
															<td class="fc-day-top fc-wed fc-other-month fc-past"
																data-date="2016-10-05"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-10-05&quot;,&quot;type&quot;:&quot;day&quot;}">5</a></td>
															<td class="fc-day-top fc-thu fc-other-month fc-past"
																data-date="2016-10-06"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-10-06&quot;,&quot;type&quot;:&quot;day&quot;}">6</a></td>
															<td class="fc-day-top fc-fri fc-other-month fc-past"
																data-date="2016-10-07"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-10-07&quot;,&quot;type&quot;:&quot;day&quot;}">7</a></td>
															<td class="fc-day-top fc-sat fc-other-month fc-past"
																data-date="2016-10-08"><a class="fc-day-number"
																data-goto="{&quot;date&quot;:&quot;2016-10-08&quot;,&quot;type&quot;:&quot;day&quot;}">8</a></td>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td></td>
															<td></td>
															<td></td>
															<td></td>
															<td></td>
															<td></td>
															<td></td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>



</body>
</html>