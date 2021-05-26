import {User} from "./user";
export interface Item {
    id: number;
    name: string;
    price: number;
    description: string;
    category: string;
    users: User;
    image: string;
  }
