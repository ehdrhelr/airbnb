import styled from 'styled-components';
import HoverBlock from '../HoverBlock';
import FormColumn from './FormColumn';
import { IoSearch } from 'react-icons/io5';
import { useRef } from 'react';
import useToggle from '../../../hooks/useToggle';
import FormGuestToggle from './guestToggle/FormGuestToggle';
import { useRecoilValue } from 'recoil';
import { guestState } from '../../../recoil/headerAtom';

const FormGuest = () => {
  const clickRef = useRef<HTMLDivElement>(null);
  const toggleRef = useRef<HTMLDivElement>(null);
  const { open } = useToggle({ clickRef, toggleRef });
  const guestCount = useRecoilValue(guestState);

  const getGuestDesc = () => {
    const total = Object.values(guestCount).reduce((acc, cur) => acc + cur);
    if (guestCount.infants > 0) {
      const infants = guestCount.infants;
      return `게스트 ${total - infants}명, 유아 ${infants}명`;
    }

    if (total === 0) return `게스트 추가`;

    return `게스트 ${total}명`;
  };

  return (
    <StyledFormGuestWrapper>
      <StyledFormGuest ref={clickRef}>
        <HoverBlock color='gray4' className='hover__guest' dataKey='guest' isModal={open}>
          <FormColumn title='인원' description={getGuestDesc()} />
          <div className='search-icon'>
            <IoSearch />
          </div>
        </HoverBlock>
      </StyledFormGuest>
      {/* {open && <FormGuestToggle toggleRef={toggleRef} />} */}
      <FormGuestToggle toggleRef={toggleRef} />
    </StyledFormGuestWrapper>
  );
};

export default FormGuest;

const StyledFormGuestWrapper = styled.div`
  position: relative;
`;

const StyledFormGuest = styled.div`
  height: 100%;
  .hover__guest {
    height: 100%;
    padding: 1rem;
    border-radius: 3rem;
    cursor: pointer;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding-right: 0.5rem;
  }
  .search-icon {
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: ${({ theme }) => theme.colors.red};
    color: ${({ theme }) => theme.colors.white};
    font-size: 1.5rem;
    width: 40px;
    height: 40px;
    border-radius: 100%;
  }
`;
