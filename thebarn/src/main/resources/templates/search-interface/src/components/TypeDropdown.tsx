import { Fragment } from "react";
import DropdownButton from "react-bootstrap/DropdownButton";
import Dropdown from "react-bootstrap/Dropdown";

function TypeDropdown() {
  return (
    <Fragment>
      <DropdownButton
        id="dropdown-type"
        className="dropdown-generic dropdown-type"
        title="minden típus"
      >
        <Dropdown.Item href="#/action-1">minden típus</Dropdown.Item>
        <Dropdown.Divider />
        <Dropdown.Item href="#/action-2">action 2</Dropdown.Item>
        <Dropdown.Item href="#/action-3">action 3</Dropdown.Item>
      </DropdownButton>
    </Fragment>
  );
}

export default TypeDropdown;
