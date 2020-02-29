export function FormAlert() {
    this.isShow = false;
    this.isSuccess = false;
    this.text = '';
}

export function showAlert(alert, isShow, isSuccess, text = '') {
    alert.isShow = isShow;
    alert.isSuccess = isSuccess;
    alert.text = text;
}