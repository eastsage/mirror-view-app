<<<<<<< frontend/src/pages/home/Header.js
  import React from 'react';
  import styled from 'styled-components';
  import { Link } from 'react-router-dom';
=======
import React from "react";
import styled from "styled-components";
>>>>>>> frontend/src/pages/home/Header.js

const Header = () => {
    return (
<<<<<<< frontend/src/pages/home/Header.js
      <Nav>
      <Link to="/"> {/* 이 부분이 추가되었습니다 */}
        <Logo></Logo>
      </Link>
        <NavMenu>
          <NavItem>
          <Link to="/about">About us</Link>
            </NavItem>
          <NavItem>
          <Link to="/notice">Notice</Link>
            </NavItem>
          <NavItem>
          <Link to="/about">StudyList</Link>
            </NavItem>
          <NavItem>
          <Link to="/mypage/profile">MyPage</Link>
            </NavItem>
          <LoginNavItem>
          <NavItem>
          <Link to="/login">로그인</Link>
          </NavItem>
          </LoginNavItem>
        </NavMenu>
      </Nav>
=======
        <Nav>
            <Logo></Logo>
            <NavMenu>
                <NavItem>About us</NavItem>
                <NavItem>Features</NavItem>
                <NavItem>Pricing</NavItem>
                <NavItem>Blog</NavItem>
                <LoginNavItem>
                    <NavItem>로그인</NavItem>
                </LoginNavItem>
            </NavMenu>
        </Nav>
>>>>>>> frontend/src/pages/home/Header.js
    );
};

const Logo = styled.div`
    width: 300px;
    height: 100px;
    margin-top: 10px;
    margin-left: 3rem;
    background-image: url(${process.env.PUBLIC_URL}/mirlogo.png);
    background-size: contain;
    background-repeat: no-repeat;
`;
const Nav = styled.nav`
    justify-content: flex-end;
    display: flex;
    align-items: center;
    padding: 0.5rem;
    background-color: #white;
`;

const NavMenu = styled.ul`
    display: flex;
    list-style: none;
    margin-left: auto;
    font-family: DAE;
`;

const NavItem = styled.li`
    margin-right: auto;
    margin-left: 5rem;
    color: 231656;
    cursor: pointer;

    &:hover {
        text-decoration: underline;
    }
`;

const LoginNavItem = styled(NavItem)`
    margin-right: 5rem;
`;

export default Header;