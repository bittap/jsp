<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="ko">
<head>
	<meta charset="utf-8">
			<title>새로운 글쓰기</title>
	
    <link rel="stylesheet" href="https://t1.daumcdn.net/tistory_admin/assets/blog/83f26b4a1af675cfb89eb6c56471443d36d03b79/blogs/style/content/font.css?_version_=83f26b4a1af675cfb89eb6c56471443d36d03b79">
    <link rel="stylesheet" href='https://t1.daumcdn.net/keditor/dist/0.4.4/style/editor-plugins.css'>
    <link rel="stylesheet" href="https://t1.daumcdn.net/tistory_admin/assets/blog/83f26b4a1af675cfb89eb6c56471443d36d03b79/blogs/style/manage/post-editor.min.css?_version_=83f26b4a1af675cfb89eb6c56471443d36d03b79">
	<link rel="stylesheet" type="text/css" href="https://mk.kakaocdn.net/dn/emoticon/static/stylesheets/sdk/1.1.3/emoticon-1.1.3.css">
	<style>
		.photos-container { position:fixed; top:0; bottom:0; left:0; right:0; z-index:60000; display:none }
	</style>
</head>

<body id="editor-root" class="tistory">
<div id="kakaoIndex">
	<!-- 웹접근성용 바로가기 링크 모음 -->
	<a href="#kakaoBody">본문 바로가기</a>
	<a href="#kakaoLnb">메뉴 바로가기</a> <!-- 2017-05-31 수정 : href 값 kakaoGnb -> kakaoLnb 로 변경 -->
</div>
<div id="post-editor-app" class="post-editor">
    <div class="box_loading">
        <span class="ico_blog ico_loading">로딩중입니다.</span>
    </div>
</div>
<div id="photosContainer" class="photos-container"></div>

<script>
	window.Config = {
		production: true,
		blog: {"image":"https:\/\/t1.daumcdn.net\/tistory_admin\/static\/manage\/images\/r3\/default_L.png","domain":"https:\/\/lionthunder.tistory.com","manageUrl":"https:\/\/lionthunder.tistory.com\/manage","title":"\uc77c\ubcf8\uc678\ub178\uc790","categories":[{"id":866832,"name":"Mybatis","label":"Mybatis","priority":0,"entries":2,"visibility":20,"viewChannel":null,"children":[],"leaf":true,"categoryInfo":{"liststyle":null,"image":null,"description":null}},{"id":866401,"name":"Spring","label":"Spring","priority":1,"entries":2,"visibility":20,"viewChannel":null,"children":[],"leaf":true,"categoryInfo":{"liststyle":null,"image":null,"description":null}}],"blogSettings":{"blogId":"3469647","url":"","logo":"","logoLabel":"","logoWidth":"0","logoHeight":"0","entriesOnPage":"6","entriesOnList":"6","entriesOnRSS":"10","publishWholeOnRSS":"1","allowWriteOnGuestbook":"1","allowWriteDoubleCommentOnGuestbook":"1","commentWritePermission":"0","useCommentRecognition":"0","useGuestbookRecognition":"0","language":"ko","timezone":"Asia\/Seoul","showLocalSearchTag":"1","useSlogan":"0","description":""},"uselessMargin":1,"plugins":[{"title":"\uc774\uc804 \uae00 \ub123\uae30","url":"\/plugin\/AddLinkToPostWithSearch\/","width":450,"height":570,"scroll":1}],"cclCommercial":0,"cclDerive":0,"visibilityType":0,"visibility":20},
		user: {"role":"owner","roleLabel":"\uc18c\uc720\uc790","name":"\ub77c\uc774\uc628\uc36c\ub354","loginId":"kinjwo1@naver.com","profileImageUrl":"https:\/\/t1.daumcdn.net\/tistory_admin\/blog\/admin\/profile_default_02.png"},
		blogs: {"ownerBlogs":[{"id":"3469647","name":"lionthunder","defaultUrl":"http:\/\/lionthunder.tistory.com","adminUrl":"http:\/\/lionthunder.tistory.com\/manage","title":"\uc77c\ubcf8\uc678\ub178\uc790"}],"memberBlogs":[]},
		post: {},
        postType: "post",
		attachments: [],
		keditor_base_url: 'https://t1.daumcdn.net/keditor/dist/0.4.4',
		MAX_ATTACHMENT_COUNT: 50,
        draftCount: "0",
        useBlogList: true	};

	window.appInfo = {
        service: "tistory",
        domain: 'tistory.com',
        topUrl: 'https://www.tistory.com',
        loginUrl: 'https://www.tistory.com/auth/login',
        logoutUrl: 'https://www.tistory.com/auth/logout',
        memberUrl: 'https://www.tistory.com/member',
        gnbBaseUrl: 'https://www.tistory.com/accio',
        manageUrl: 'https://lionthunder.tistory.com/manage',
        thumbnailBaseUrl: 'https://img1.daumcdn.net/thumb',
        returnUrl: '/manage/posts/',
        fontStyleUrl: "https://t1.daumcdn.net/tistory_admin/assets/blog/83f26b4a1af675cfb89eb6c56471443d36d03b79/blogs/style/content/font.css?_version_=83f26b4a1af675cfb89eb6c56471443d36d03b79",
        contentStyleUrl: "https://t1.daumcdn.net/tistory_admin/assets/blog/83f26b4a1af675cfb89eb6c56471443d36d03b79/blogs/style/manage/editor/editor-content.css?_version_=83f26b4a1af675cfb89eb6c56471443d36d03b79"
	};

	window.daumLikeCategories = [{"value":"100","label":"\ub77c\uc774\ud504","subItems":[{"value":"101","label":"\uc77c\uc0c1\ub2e4\ubc18\uc0ac"},{"value":"102","label":"\ud574\uc678\uc0dd\ud65c"},{"value":"103","label":"\uc5f0\uc560\u00b7\uacb0\ud63c"},{"value":"104","label":"\uc721\uc544"},{"value":"105","label":"\uc0dd\ud65c\uc815\ubcf4"},{"value":"106","label":"\ubc18\ub824\ub3d9\ubb3c"},{"value":"107","label":"\ucde8\ubbf8"},{"value":"108","label":"\uc0ac\uc9c4"},{"value":"109","label":"\uc694\ub9ac"},{"value":"110","label":"\uc790\ub3d9\ucc28"},{"value":"111","label":"\uc778\ud14c\ub9ac\uc5b4"},{"value":"112","label":"\ud328\uc158\ubdf0\ud2f0"},{"value":"113","label":"\uac74\uac15"},{"value":"114","label":"\uad70\ub300"}]},{"value":"200","label":"\uc5ec\ud589\u00b7\ub9db\uc9d1","subItems":[{"value":"201","label":"\uad6d\ub0b4\uc5ec\ud589"},{"value":"202","label":"\ud574\uc678\uc5ec\ud589"},{"value":"203","label":"\ucea0\ud551\u00b7\ub4f1\uc0b0"},{"value":"204","label":"\ub9db\uc9d1"},{"value":"205","label":"\uce74\ud398\u00b7\ub514\uc800\ud2b8"}]},{"value":"300","label":"\ubb38\ud654\u00b7\uc5f0\uc608","subItems":[{"value":"301","label":"TV"},{"value":"302","label":"\uc2a4\ud0c0"},{"value":"303","label":"\uc601\ud654"},{"value":"304","label":"\uc74c\uc545"},{"value":"305","label":"\ucc45"},{"value":"306","label":"\ub9cc\ud654\u00b7\uc560\ub2c8"},{"value":"307","label":"\uacf5\uc5f0\u00b7\uc804\uc2dc\u00b7\ucd95\uc81c"},{"value":"308","label":"\ucc3d\uc791"}]},{"value":"400","label":"IT","subItems":[{"value":"401","label":"IT \uc778\ud130\ub137"},{"value":"402","label":"\ubaa8\ubc14\uc77c"},{"value":"403","label":"\uac8c\uc784"},{"value":"404","label":"\uacfc\ud559"},{"value":"405","label":"IT \uc81c\ud488\ub9ac\ubdf0"}]},{"value":"500","label":"\uc2a4\ud3ec\uce20","subItems":[{"value":"506","label":"\uc2a4\ud3ec\uce20\uc77c\ubc18"},{"value":"501","label":"\ucd95\uad6c"},{"value":"502","label":"\uc57c\uad6c"},{"value":"503","label":"\ub18d\uad6c"},{"value":"504","label":"\ubc30\uad6c"},{"value":"505","label":"\uace8\ud504"}]},{"value":"600","label":"\uc2dc\uc0ac","subItems":[{"value":"601","label":"\uc815\uce58"},{"value":"602","label":"\uc0ac\ud68c"},{"value":"603","label":"\uad50\uc721"},{"value":"604","label":"\uad6d\uc81c"},{"value":"605","label":"\uacbd\uc81c"},{"value":"606","label":"\uacbd\uc601\u00b7\uc9c1\uc7a5"}]}]
	window.user = window.Config.user;
</script>

<script src="https://t1.daumcdn.net/fp/photos/dist/1.2.4/photos.standalone.min.js"></script>
<!-- <script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script> -->


<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/polyfill.min.js"></script>
<script src="https://t1.daumcdn.net/keditor/tinymce/4.9.3/tinymce.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/themes/classic/theme.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/codeblock/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/maps/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/kImage/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/fileUpload/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/video/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/kData/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/location/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/simpleTable/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/klink/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/kPaste/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/newPaste/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/colorPalette/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/grammarCheck/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/newOg/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/styleFormat/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/kList/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/hrList/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/moreLess/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/fontSelect/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/imageSlide/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/kTable/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/plugins/kCharmap/plugin.min.js"></script>
<script type="text/javascript" src="https://t1.daumcdn.net/keditor/dist/0.4.4/langs/ko_KR.min.js"></script>

<script src="https://t1.daumcdn.net/tistory_admin/assets/blog/83f26b4a1af675cfb89eb6c56471443d36d03b79/blogs/script/manage/post-editor.min.js?_version_=83f26b4a1af675cfb89eb6c56471443d36d03b79"></script>

</body>
</html>