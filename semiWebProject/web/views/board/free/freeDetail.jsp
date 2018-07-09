<%@page import="java.util.ArrayList"%>
<%@page import="board.free.model.vo.FreeReplyVo"%>
<%@page import="board.free.model.vo.FreeVo"%>
<%@page import="admin.notice.model.vo.NoticeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	FreeVo free = (FreeVo)request.getAttribute("board"); 
	ArrayList<FreeReplyVo> list = (ArrayList<FreeReplyVo>)request.getAttribute("replyList");
	Integer currentPage = (Integer)request.getAttribute("currentPage");
	MemberVo member = (MemberVo) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<style>
	.outer{
		width:800px;
		height:500px;
		background:white;
		color:black;
		margin-left:auto;
		margin-right:auto;
		padding:20px;
		border:1px solid #7c65b2;
	}
	#deleteBtn{
		width:150px;
		height:30px;
		background:#7c65b2;
		color:white;
		text-align:center;
		vertical-align:middle;
		display:table-cell;
		border-radius:5px;
		cursor:pointer;
	}
</style>
<meta charset="UTF-8">
<script>
	function deleteNotice(){
		if(confirm("삭제하시겠습니까?")){
			//location.href="/swp/deleteNotice.do?noticeNo=<%=free.getBoard_no()%>";
		}
	}

</script>
<title>원</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<div class="outer">
	<h2 align="center">자유게시판 상세 내용</h2>
	<div class="tableArea">
		<table width="800">
			<tr>
				<th>제목</th>
				<td colspan="5"><%=free.getTitle()%></td>
			</tr>	
			<tr>
				<th width="200">작성자</th>
				<td><%=free.getNickname() %></td>
				<th width="100">조회수</th>
				<td><%=free.getBoard_count() %></td>
				<th width="100">작성일</th>
				<td><%=free.getBoard_date() %></td>
			</tr>
			<tr>
				<th>내용</th>
			</tr>
			<tr>
				<td colspan="6">
					<p><%=free.getBoard_content() %></p>
				</td>
			</tr>
		</table>
	</div>
	<div align="center">
		<button onclick="boardPageList();">목록으로</button>
		<%if(null != member && member.getUserId().equals(free.getMember_id())){ %>
			<button onclick="updateBoard();">수정하기</button>
			<button onclick="deleteBoard();">삭제하기</button>
		<%} %>
	</div>
	<div class="commentArea">
		<table width="800">
		</table>
	</div>
	<%if(member != null){ %>
	<div class="commentWriteArea">
		<form method="post" id="commentForm" action="writeComment.do">
			<table width="800">
				<input type="hidden" name="bno" value="<%=free.getBoard_no()%>"/>
				<input type="hidden" name="writer"	value="<%=member.getUserId() %>"/>
				<tr>
					<td>
						댓글 : <input type="text" size="40"  name="content" id="comment"/>
					</td>
					<td>
						<!-- <input type="submit" value="댓글작성"/> -->
						<input type="button" id="replyWriteBtn" onclick="writeComment();" value="댓글작성"/>
						<input type="button" id="replyUpdateBtn" onclick="updateComment();" value="수정"/>
						<input type="button" id="replyCancelBtn" onclick="cancelComment();" value="취소"/>
						
					</td>
				</tr>
			</table>		
		</form>
	</div>
	<%} %>
	<table id="replyTable">
		<%for(FreeReplyVo reply : list){ %>
		<tr>
			<td><%=reply.getNickname()%></td>
			<td><%=reply.getReply_content() %></td>
			<%if(reply.getMember_id().equals(member.getUserId())){ %>	
				<td>
					<a onclick="updateReply(<%=reply.getReply_no() %>, '<%=reply.getReply_content() %>')">수정</a>
					<a onclick="deleteReply(<%=reply.getReply_no() %>)">삭제</a>
				</td>			
			<%}else{%>
				<td></td>
			<%}%>
		</tr>
		<%} %>
	</table>
</div>
<%@ include file="/views/common/footer.jsp"%>
<script>
function boardPageList(){
	location.href = "/swp/freeList.do?currentPage=<%=currentPage%>";
}

function setReplyList(data){
	$table = $("#replyTable");
	$table.empty();
	for(var i in data){
		var tr = $("<tr>");
		var userTd = $("<td>").text(data[i].nickname);				
		var contentTd = $("<td>").text(data[i].reply_content);
		tr.append(userTd);
		tr.append(contentTd);
		var actionTd
		if(data[i].member_id == '<%=member.getUserId()%>'){
			actionTd = $("<td><a onclick='updateReply("+data[i].reply_no+", \""+data[i].reply_content+"\")'>수정</a><a onclick='deleteReply("+data[i].reply_no+")'>삭제</a></td>");
		}else{
			actionTd = $("<td></td>");
		}
		tr.append(actionTd);
		$table.append(tr);
	}
	$("#comment").val("");
}

function writeComment(){
	$.ajax({
		url:"/swp/writeComment.do",
		data:{
			comment:$("#comment").val(),
			userId:'<%=member.getUserId()%>',
			bno:<%=free.getBoard_no()%>
		},type:"get",
		success:function(data){
// 			$table = $("#replyTable");
// 			$table.empty();
// 			for(var i in data){
// 				var tr = $("<tr>");
// 				var userTd = $("<td>").text(data[i].nickname);				
// 				var contentTd = $("<td>").text(data[i].reply_content);				
// 				var actionTd = $("<td><a>수정</a><a onclick='deleteReply("+data[i].reply_no+")'>삭제</a></td>");
// 				tr.append(userTd);
// 				tr.append(contentTd);
// 				tr.append(actionTd);
// 				$table.append(tr);
// 			}
// 			$("#comment").val("");

			setReplyList(data);
		},error:function(e){
			console.log(e);
		}
	});
}

function deleteReply(replyNo){
	if(!confirm("삭제 하시겠습니까?")){
		return;
	}
	$.ajax({
		url:"/swp/deleteReply.do",
		data:{
			replyNo:replyNo,
			bNo:<%=free.getBoard_no()%>
		},type:"get",
		success:function(data){
// 			$table = $("#replyTable");
// 			$table.empty();
// 			for(var i in data){
// 				var tr = $("<tr>");
// 				var userTd = $("<td>").text(data[i].nickname);				
// 				var contentTd = $("<td>").text(data[i].reply_content);
// 				tr.append(userTd);
// 				tr.append(contentTd);
// 				var actionTd
<%-- 				if(data[i].member_id == '<%=member.getUserId()%>'){ --%>
// 					actionTd = $("<td><a>수정</a><a onclick='deleteReply("+data[i].reply_no+")'>삭제</a></td>");
// 				}else{
// 					actionTd = $("<td></td>");
// 				}
// 				tr.append(actionTd);
// 				$table.append(tr);
// 			}
// 			$("#comment").val("");
			setReplyList(data);
		},error:function(e){
			console.log(e);
		}
	});
}

var modifyNo;
function updateReply(reply_no, content){
	$("#comment").val(content).focus();
	modifyNo = reply_no;
	setBtnVisible(false);
}

function updateComment(){
	$.ajax({
		url:"/swp/updateComment.do",
		data:{
			comment:$("#comment").val(),
			cno:modifyNo,
			bno:<%=free.getBoard_no()%>
		},type:"get",
		success:function(data){
			setReplyList(data);
			setBtnVisible(true);
		},error:function(e){
			console.log(e);
		}
	});
	
}

function cancelComment(){
	if(confirm("댓글 수정을 취소 하시겠습니까?")){
		setBtnVisible(true);
		$("#comment").val("");
	}
	
}
$(function(){
	setBtnVisible(true);
});

function setBtnVisible(flag){
	if(flag){
		$("#replyWriteBtn").show();
		$("#replyUpdateBtn").hide();
		$("#replyCancelBtn").hide();
	}else{
		$("#replyWriteBtn").hide();
		$("#replyUpdateBtn").show();
		$("#replyCancelBtn").show();
	}
}

function deleteBoard(){
	if(!confirm("해당 게시글을 삭제 하시겠습니까?")){
		return;
	}
	
	$.ajax({
		url:"/swp/deleteBoard.do",
		data:{
			bno:<%=free.getBoard_no()%>
		},type:"get",
		success:function(data){
			console.log(data);
			if(data == 1){
				alert("게시글이 삭제 되었습니다.");
				location.href="/swp/freeList.do?currentPage=<%=currentPage%>";
			}else{
				alert("게시글 삭제 시 오류가 발생하였습니다.");
			}
		},error:function(e){
			console.log(e);
		}
	});
}

function updateBoard(){
	location.href = "/swp/updateFreeForm.do?bno=<%=free.getBoard_no()%>";
	
	
}
</script>
</body>
</html>