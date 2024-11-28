import { Fragment } from "react";
import DropdownButton from "react-bootstrap/DropdownButton";
import Dropdown from "react-bootstrap/Dropdown";

function ButtonDropdown() {
  return (
    <Fragment>
      <DropdownButton id="dropdown-plus" className="btn-plus" title="">
        <Dropdown.Item href="./cattle_registration">
          Új állat hozzáadása
        </Dropdown.Item>
        <Dropdown.Item href="./registration">
          Új állattenyészet hozzáadása
        </Dropdown.Item>
      </DropdownButton>
    </Fragment>
  );
}

export default ButtonDropdown;
