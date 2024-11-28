import { Fragment } from "react";
import DropdownButton from "react-bootstrap/DropdownButton";
import Dropdown from "react-bootstrap/Dropdown";

function BreedDropdown() {
  return (
    <Fragment>
      <DropdownButton
        id="dropdown-breed"
        className="dropdown-generic dropdown-breed"
        title="minden fajta"
      >
        <Dropdown.Item href="#/action-1">minden fajta</Dropdown.Item>
        <Dropdown.Divider />
        <Dropdown.Item href="#/action-2">action 2</Dropdown.Item>
        <Dropdown.Item href="#/action-3">action 3</Dropdown.Item>
      </DropdownButton>
    </Fragment>
  );
}

export default BreedDropdown;
