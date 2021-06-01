import { atom, selector } from 'recoil';
import { timeToDate } from '../components/header/form/calendar/calendarDateFn';
import { guestStateType } from '../components/header/form/guestToggle/guestType';
import { selectDateState } from './calendarAtom';

export const tabSelectedState = atom<boolean[]>({
  key: 'tabSelectedState',
  default: [true, false, false],
});

export const selectCheckBoxState = atom<string>({
  key: 'selectCheckBoxState',
  default: '',
});

export const isFormOpenedState = atom<boolean>({
  key: 'isFormOpenedState',
  default: false,
});

export const locationState = atom({
  key: 'locationState',
  default: '',
});

export const priceState = atom({
  key: 'priceState',
  default: { min: 10000, max: 1000000 },
});

export const pauseBtnPositionState = atom({
  key: 'pauseBtnPositionState',
  default: { left: 0, right: 0 },
});

export const pauseBtnLastPositionState = atom({
  key: 'pauseBtnLastPositionState',
  default: { left: 0, right: 0 },
});

export const guestState = atom<guestStateType>({
  key: 'guestState',
  default: { adult: 0, child: 0, infants: 0 },
});

export const reserveInfoSelector = selector({
  key: 'reserveInformation',
  get: ({ get }) => {
    const address = get(locationState);
    const selectDateData = get(selectDateState);
    const checkIn = timeToDate(selectDateData.checkIn);
    const checkOut = timeToDate(selectDateData.checkOut);
    const priceData = get(priceState);
    const minCharge = priceData.min;
    const maxCharge = priceData.max;
    const guestData = get(guestState);
    const guests = Object.values(guestData).reduce((acc, cur) => acc + cur);
    return { address, checkIn, checkOut, minCharge, maxCharge, guests };
  },
});
