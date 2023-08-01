import * as S from "./StudyStyledComponents";

const StudyRoomThumbnail = (info) => {
    const handleEnter = () => {
        if (
            window.confirm(
                `${info.host}님이 생성한 ${info.title}에 입장하시겠습니까?`
            )
        ) {
            // 방 입장 api
        }
    };
    return (
        <S.thumbnailPage>
            <S.titleAndHost>
                <div>{info.title}</div>
                <div>{info.host}</div>
                <div>{info.category}</div>
            </S.titleAndHost>
            <S.personAndButton>
                <div>
                    {info.currentMemberCount} / {info.maxMemberCount}
                </div>
                <S.enterButtonDiv>
                    <S.enterButton onClick={() => handleEnter(info)}>
                        입장하기
                    </S.enterButton>
                </S.enterButtonDiv>
            </S.personAndButton>
        </S.thumbnailPage>
    );
};

export default StudyRoomThumbnail;
