
var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () { _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });

    },
    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });

    }

};

main.init();


    /*
       06/06
       1. window.location.href='/'
       -> 글 등록이 성공하면 메인페이지(/)로 이동함.

       - index.js의 첫 문장에 var main = {...}라는 코드를 선언한 이유
       (굳이 index라는 변수의 속성으로 function을 추가한 이유)

       : 프로젝트에서는 함수(function) 이름 중복이 자주 발생할 수 있음.(모든 function의 이름 확인 불가)
       이런 문제를 피하려고 index.js만의 유효범위(scope)를 만들어 사용함.
       -> var index란 객체를 만들어 해당 객체에서 필요한 모든 function을 선언하는 것.
          이렇게 하면 index 객체 안에서만 function이 유효하가ㅣ 때문에 다른 JS와 겹칠 위험이 사라짐.

    */